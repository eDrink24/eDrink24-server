package org.eDrink24.controller;

import org.eDrink24.dto.product.ProductDTO;
import org.eDrink24.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class mainController {

    ProductService productService;
    public mainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }
}
