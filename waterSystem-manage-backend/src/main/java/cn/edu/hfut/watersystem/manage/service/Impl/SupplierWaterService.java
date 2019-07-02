package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.mapper.SupplierWaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 葛学文
 * @date 2019/6/14 23:55
 */
@Service
public class SupplierWaterService implements cn.edu.hfut.watersystem.manage.service.SupplierWaterService {

    @Autowired
    SupplierWaterMapper supplierWaterMapper;

    @Override
    public void addSupplierWater(int supplierID, int waterID) {
        supplierWaterMapper.insertSupplierWater(supplierID, waterID);
    }
}
