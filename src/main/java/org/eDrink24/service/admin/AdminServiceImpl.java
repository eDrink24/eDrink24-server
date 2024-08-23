package org.eDrink24.service.admin;

import org.eDrink24.config.AdminMapper;
import org.eDrink24.dto.admin.AdminDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public void updateStateAfterCompletedPickup(Integer ordersId) {
        adminMapper.ChangeStatusAndDate(ordersId);
        adminMapper.changeIsCompleted(ordersId);
        adminMapper.changeInventoryQuantity(ordersId);
    }

    @Override
    public List<AdminDTO> showPickupCompletedPage() {
        return adminMapper.showPickupCompletedPage();
    }

    @Override
    public List<AdminDTO> showTodayPickupPage() {
        return adminMapper.showTodayPickupPage();
    }
}
