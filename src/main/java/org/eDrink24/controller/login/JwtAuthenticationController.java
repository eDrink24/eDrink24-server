package org.eDrink24.controller.login;

import org.eDrink24.domain.customer.Customer;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.security.JwtTokenResponse;
import org.eDrink24.security.JwtTokenService;
import org.eDrink24.service.customer.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class JwtAuthenticationController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private JwtTokenService tokenService;
    private AuthenticationService authenticationService;
    private PasswordEncoder passwordEncoder;

    public JwtAuthenticationController(JwtTokenService tokenService,
                                       AuthenticationService authenticationService,
                                       PasswordEncoder passwordEncoder) {
        this.tokenService  = tokenService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> authenticate(
            @RequestBody Map<String, String> jwtTokenRequest) {
        logger.info("logger: jwtTokenRequest: {}", jwtTokenRequest);

        CustomerDTO customerDTO = authenticationService.findByLoginId(jwtTokenRequest.get("loginId"));
        UsernamePasswordAuthenticationToken authenticationToken = null;

        System.out.println(customerDTO.toString()); // 1. DTO 받아와짐
        System.out.println(passwordEncoder.matches(jwtTokenRequest.get("pw"), customerDTO.getPw()));

        if (customerDTO != null && passwordEncoder.matches(jwtTokenRequest.get("pw"), customerDTO.getPw())) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("일반회원"));
            CustomerDTO authCustomer =
                    CustomerDTO.builder()
                            .loginId(jwtTokenRequest.get("loginId"))
                            .pw(jwtTokenRequest.get("pw"))
                            .userName(customerDTO.getUserName())
                            .role(customerDTO.getRole()).build();
            logger.info(authCustomer.toString());
            authenticationToken =
                    new UsernamePasswordAuthenticationToken(authCustomer, null, roles);
        }

        String token = null;
        // token이 있을때만 생성
        if (authenticationToken != null) {
            token = tokenService.generateToken(authenticationToken);
        }
        return ResponseEntity.ok(new JwtTokenResponse(token));
    }

}
