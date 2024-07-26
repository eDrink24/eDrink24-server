package org.eDrink24.service.customer;

import org.eDrink24.dto.customer.CustomerDTO;

public interface CustomerService {
    public CustomerDTO saveCustomer(CustomerDTO customer);
    public CustomerDTO selectCustomerMyPage(String loginId);
    public int updateCustomerToMyPage(CustomerDTO customerDTO);

    // 회원가입할 때 아이디 중복체크
    public CustomerDTO customerIdCheck(String loginId);
}
