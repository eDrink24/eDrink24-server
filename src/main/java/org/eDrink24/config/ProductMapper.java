package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.product.ProductDTO;

import java.util.List;

@Mapper
public interface ProductMapper {

    public List<ProductDTO> showAllProduct();

}
