package org.eDrink24.service.customer;

import org.eDrink24.domain.customer.Customer;
import org.eDrink24.dto.customer.CustomerDTO;

public interface CustomerService {
    public CustomerDTO saveCustomer(CustomerDTO customer);
    public CustomerDTO selectCustomerByLoginId(String loginId);
    public int updateCustomerToMyPage(CustomerDTO customerDTO);
    // 회원가입할때 아이디 중복체크
    public CustomerDTO customerIdCheck(String loginId);
    // 아이디 찾기
    public String findByUserNameAndEmail(String userName, String email);
}
