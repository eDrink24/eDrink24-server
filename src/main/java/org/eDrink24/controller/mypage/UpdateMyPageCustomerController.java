package org.eDrink24.controller.mypage;

import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.service.customer.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class UpdateMyPageCustomerController {

    CustomerService customerService;

    public UpdateMyPageCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PutMapping(value = {"/updateMyPageCustomer/{loginId}"})
    public ResponseEntity<CustomerDTO> updateMyPageCustomer(@PathVariable String loginId,
                                                            @RequestBody CustomerDTO customerDTO) {

        customerDTO.setLoginId(loginId);

        String ecrptPW = new BCryptPasswordEncoder().encode(customerDTO.getPw());
        customerDTO.setPw(ecrptPW);

        customerService.updateCustomerToMyPage(customerDTO);
        return ResponseEntity.ok(customerDTO);
    }

}
