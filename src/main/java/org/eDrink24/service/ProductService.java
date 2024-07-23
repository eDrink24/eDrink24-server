package org.eDrink24.service;

import org.eDrink24.dto.product.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> findAll();
}
