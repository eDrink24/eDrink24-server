package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.customer.CustomerDTO;

@Mapper
public interface CustomerMapper {
    public int saveCustomer(CustomerDTO customerDTO);
}
