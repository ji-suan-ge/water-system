package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.Supplier;
import cn.edu.hfut.watersystem.manage.mapper.SupplierMapper;
import cn.edu.hfut.watersystem.manage.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 21:36
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierMapper.selectAllSupplier();
    }

    @Override
    public void deleteSupplier(int supplierID) {
        supplierMapper.deleteSupplier(supplierID);
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.insertSupplier(supplier);
    }

    @Override
    public List<Supplier> getNotSupplierList(int waterID) {
        return supplierMapper.selectNotSupplierList(waterID);
    }

    @Override
    public List<Supplier> getYetSupplierList(int waterID) {
        return supplierMapper.selectYetSupplierList(waterID);
    }
}
