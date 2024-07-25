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

    @Override
    public List<ProductDTO> showProductByCategory1(String category1) {
        return productMapper.showProductByCategory1(category1);
    }

    @Override
    public List<ProductDTO> showProductByCategory2(String category2) {
        return productMapper.showProductByCategory2(category2);
    }


}
