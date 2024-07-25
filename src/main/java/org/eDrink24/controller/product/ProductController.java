package org.eDrink24.controller.product;

import org.eDrink24.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.eDrink24.dto.product.ProductDTO;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class ProductController {

private Logger logger = LoggerFactory.getLogger(getClass());
  
ProductService productService;

   public ProductController(ProductService productService) {
        this.productService = productService;
   }

	// 상품 필터링
	@GetMapping("/products/order/{order}/direction/{direction}")
	public List<ProductDTO> filterProduct(
			@PathVariable String order,
			@PathVariable String direction) {
		return productService.productFilter(order, direction);
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
