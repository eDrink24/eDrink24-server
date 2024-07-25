package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.product.ProductDTO;

import java.util.List;

@Mapper
public interface ProductMapper {

    public List<ProductDTO> showAllProduct();

    // category1에 해당하는 제품만 보여줌.
    public List<ProductDTO> showProductByCategory1(String category1);

}
