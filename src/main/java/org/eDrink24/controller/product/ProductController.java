package org.eDrink24.controller.product;

import org.eDrink24.dto.product.ProductDTO;
import org.eDrink24.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 제품 전체 목록 보여주기
    @GetMapping(value = {"/showAllProduct"})
    public List<ProductDTO> showAllProduct() {
        return productService.showAllProduct();
    }

    // category1에 해당하는 제품 목록 보여주기
    @GetMapping(value = {"/showProductByCategory1/{category1}"})
    public List<ProductDTO> showProductByCategory1(@PathVariable String category1) {
        return productService.showProductByCategory1(category1);
    }

}
