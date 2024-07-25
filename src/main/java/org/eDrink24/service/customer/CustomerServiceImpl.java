package org.eDrink24.service.customer;

import lombok.extern.slf4j.Slf4j;
import org.eDrink24.config.CustomerMapper;
import org.eDrink24.dto.customer.CustomerDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService{

    CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
        public CustomerDTO saveCustomer(CustomerDTO customer) {
        log.info("실행 여부 확인");
        int n = customerMapper.saveCustomer(customer);
        return customer;
    }

    @Override
    public CustomerDTO selectCustomerMyPage(String loginId) {
        return customerMapper.selectCustomerMyPage(loginId);
    }


}
