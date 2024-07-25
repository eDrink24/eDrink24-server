package org.eDrink24.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.security.JwtTokenResponse;
import org.eDrink24.security.JwtTokenService;
import org.eDrink24.service.customer.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class JwtAuthenticationController {

    private final JwtTokenService tokenService;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthenticationController(JwtTokenService tokenService,
                                       AuthenticationService authenticationService,
                                       PasswordEncoder passwordEncoder) {
        this.tokenService = tokenService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> authenticate(
            @RequestBody Map<String, String> jwtTokenRequest) {
        log.info("logger: jwtTokenRequest: {}", jwtTokenRequest);

        CustomerDTO customerDTO = authenticationService.findByLoginId(jwtTokenRequest.get("loginId"));
        if (customerDTO == null) {
            return ResponseEntity.status(401).body(new JwtTokenResponse(null)); // Unauthorized
        }

        if (passwordEncoder.matches(jwtTokenRequest.get("pw"), customerDTO.getPw())) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("일반회원"));
            CustomerDTO authCustomer =
                    CustomerDTO.builder()
                            .loginId(jwtTokenRequest.get("loginId"))
                            .pw(jwtTokenRequest.get("pw"))
                            .userName(customerDTO.getUserName())
                            .role(customerDTO.getRole()).build();
            log.info(authCustomer.toString());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(authCustomer, null, roles);

            String token = tokenService.generateToken(authenticationToken);
            return ResponseEntity.ok(new JwtTokenResponse(token));
        } else {
            return ResponseEntity.status(401).body(new JwtTokenResponse(null)); // Unauthorized
        }
    }
}
