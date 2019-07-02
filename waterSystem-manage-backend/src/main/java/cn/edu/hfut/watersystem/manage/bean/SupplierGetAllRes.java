package cn.edu.hfut.watersystem.manage.bean;

import cn.edu.hfut.watersystem.manage.entity.Supplier;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 21:40
 */
public class SupplierGetAllRes {
    private List<Supplier> supplierList;

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }
}
