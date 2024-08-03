package org.eDrink24.dto.basket;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;


@Alias("BasketDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BasketDTO {

	private Integer basketId;
	private Integer userId;
	private Boolean deleted;
	private List<BasketItemDTO> items;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class BasketItemDTO {
		private String loginId;
		private Integer productId;
		private String defaultImage;
		private String productName;
		private Integer price;
		private Integer basketQuantity;
	}
}
