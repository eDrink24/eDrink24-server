package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.product.ProductDTO;

import java.util.List;
import java.util.Map;


@Mapper
public interface ProductMapper {

	public List<ProductDTO> productFilter(Map<String, Object> params); // 상품 필터링

	
	
}
