package org.eDrink24.service.product;

import org.eDrink24.dto.product.ProductDTO;

import java.util.List;

public interface ProductService {


    public List<ProductDTO> showAllProduct();

    // category1에 해당하는 제품만 보여줌.
    public List<ProductDTO> showProductByCategory1(String category1);

}
