package org.eDrink24.controller.login;

import org.eDrink24.domain.customer.Customer;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.service.customer.AuthenticationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

    AuthenticationService authenticationService;
    public JwtAuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/findByLoginId/{loginId}")
    public CustomerDTO findByLoginId(@PathVariable String loginId) {
        return authenticationService.findByLoginId(loginId);
    }
}
