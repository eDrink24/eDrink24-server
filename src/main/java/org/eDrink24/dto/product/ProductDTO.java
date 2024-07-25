package org.eDrink24.dto.product;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Alias("ProductDTO")
public class ProductDTO {
	
	Integer productId;
	String productName;
	String category1;
	String category2;
	Integer promotionId;
	int price;
	String defaultImage;
	int countDibs;
	boolean isCoupon;
	boolean isPoint;
	LocalDate enrollDate;

	
}
