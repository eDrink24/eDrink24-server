package org.eDrink24.service.product;

import org.eDrink24.config.ProductMapper;
import org.eDrink24.dto.product.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {

    ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> showAllProduct() {
        return productMapper.showAllProduct();
    }
}
