package org.eDrink24;

import org.eDrink24.domain.customer.Customer;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.service.customer.AuthenticationService;
import org.eDrink24.service.customer.AuthenticationServiceImpl;
import org.eDrink24.service.customer.CustomerService;
import org.eDrink24.service.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class OrderTests {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private OrderService orderService;

    @Test
    public void ConcurrencyTest() throws InterruptedException {
        // 3명 로그인
        CustomerDTO customer1 = authenticationService.authenticate("hmdkcm1", "$2a$10$Ezosoh6hRbwhxarWiCQfgOWCFieNzWvIpKnc1dc350arucz2rWi8.");
        CustomerDTO customer2 = authenticationService.authenticate("hmdkcm2", "$2a$10$o5VcW4gA8yEHjvHSZVaRzehglKSay7Y8zD3utsxhT/06KSwC7Ql52");
        CustomerDTO customer3 = authenticationService.authenticate("hmdkcm3", "$2a$10$l0/eoQxrVX7otDNWd3J7R./FwOj.xTzaMIX6ysVGWCDrQEWLuNl.e");
    }
}
