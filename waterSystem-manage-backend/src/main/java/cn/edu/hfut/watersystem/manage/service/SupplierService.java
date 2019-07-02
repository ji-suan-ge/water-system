package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.entity.Supplier;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 21:35
 */
public interface SupplierService {
    List<Supplier> getAllSupplier();

    void deleteSupplier(int supplierID);

    void addSupplier(Supplier supplier);

    List<Supplier> getNotSupplierList(int waterID);

    List<Supplier> getYetSupplierList(int waterID);
}
