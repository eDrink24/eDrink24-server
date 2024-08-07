package org.eDrink24.service.customer;

import lombok.extern.slf4j.Slf4j;
import org.eDrink24.config.CustomerMapper;
import org.eDrink24.domain.customer.Customer;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.repository.customer.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
        public CustomerDTO saveCustomer(CustomerDTO customer) {
        log.info("실행 여부 확인");
        int n = customerMapper.saveCustomer(customer);
        return customer;
    }

    @Override
    public CustomerDTO selectCustomerByLoginId(String loginId) {
        return customerMapper.selectCustomerMyPage(loginId);
    }

    @Override
    public int updateCustomerToMyPage(CustomerDTO customerDTO) {
        int n = customerMapper.updateCustomerToMyPage(customerDTO);
        return n;
    }

    @Override
    public CustomerDTO customerIdCheck(String loginId) {
        return customerMapper.customerIdCheck(loginId);
    }

    // 아이디 찾기
    @Override
    public String findByUserNameAndEmail(String userName, String email) {
        Customer customer = customerRepository.findByUserNameAndEmail(userName, email);
        String loginId = customer.getLoginId();
        return loginId;
    }

    // 비밀번호 찾기
    @Override
    public CustomerDTO findByLoginIdAndEmail(String loginId, String email) {
        Customer customer = customerRepository.findByLoginIdAndEmail(loginId, email);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }
}
