package org.eDrink24.service.customer;

import org.eDrink24.dto.customer.CustomerDTO;

public interface CustomerService {
    public CustomerDTO saveCustomer(CustomerDTO customer);
    public CustomerDTO selectCustomerMyPage(String loginId);
    public int updateCustomerToMyPage(CustomerDTO customerDTO);
}
