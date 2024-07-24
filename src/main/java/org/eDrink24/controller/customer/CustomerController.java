package org.eDrink24.controller.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.service.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // 회원가입
    @PostMapping(value={"/signup"})
    public ResponseEntity<CustomerDTO> signup(@Valid @RequestBody CustomerDTO customer) {

        // 입력된 비번은 반드시 암호해해야 된다.
        String ecrptPW = new BCryptPasswordEncoder().encode(customer.getPw());
        customer.setPw(ecrptPW);
        log.info("customer: {}", customer);
        CustomerDTO saveCustomer = customerService.saveCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(saveCustomer.getLoginId()) //위의 {userid}를 치환시킴.
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
