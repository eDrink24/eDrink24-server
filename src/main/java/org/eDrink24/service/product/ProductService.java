package org.eDrink24.service.product;

import org.eDrink24.dto.product.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {


	public List<ProductDTO> productFilter(String order, String direction); // 상품 필터링
	

	
	
}
