package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.eDrink24.dto.admin.AdminDTO;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminMapper {

    // 픽업완료버튼 클릭 시 IsCompleted true로 변경,
    public int changeIsCompleted(@Param("ordersId") Integer ordersId);

    // changeStatus PICKUPED, changeDate 버튼 클릭 한 시간으로 변경
    public int ChangeStatusAndDate(@Param("ordersId") Integer ordersId);

    // 픽업완료버튼 클릭 시 inventory테이블 수량 변경
    public int changeInventoryQuantity(@Param("ordersId") Integer ordersId);

    // 픽업완료 내역페이지에서 픽업주문처리가 완료된 것만 보여줌. (isCompleted가 true)
    public List<AdminDTO> showPickupCompletedPage();

    // 즉시픽업페이지에서 즉시픽업이 아직 이루어지지 않은 것만 보여줌. (isCompleted가 false)
    public List<AdminDTO> showPickupPage();


}
