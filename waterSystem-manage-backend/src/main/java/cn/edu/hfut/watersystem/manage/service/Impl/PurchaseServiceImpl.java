package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.Purchase;
import cn.edu.hfut.watersystem.manage.mapper.PurchaseMapper;
import cn.edu.hfut.watersystem.manage.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 葛学文
 * @date 2019/6/15 0:36
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public void addPurchase(Purchase purchase) {
        purchaseMapper.insertPurchase(purchase);
    }
}
