package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.customer.CustomerDTO;

@Mapper
public interface CustomerMapper {
    public int saveCustomer(CustomerDTO customerDTO);
    public CustomerDTO selectCustomerMyPage(String loginId);
    public int updateCustomerToMyPage(CustomerDTO customerDTO);

    // 회원가입할 때 아이디 중복체크
    public CustomerDTO CustomerIdCheck(String loginId);
}
