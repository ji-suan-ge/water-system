package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.bean.*;
import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.entity.Supplier;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 21:38
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 获取供应商列表
     */
    @PostMapping(value = "getAll")
    public Message getAll() {

        List<Supplier> supplierList = supplierService.getAllSupplier();

        SupplierGetAllRes supplierGetAllRes = new SupplierGetAllRes();
        supplierGetAllRes.setSupplierList(supplierList);

        return ResultUtil.success(supplierGetAllRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 删除供应商
     */
    @PostMapping(value = "delete")
    public Message deleteStaff(@Valid @RequestBody SupplierDeleteReq supplierDeleteReq) {

        int supplierID = supplierDeleteReq.getSupplierID();

        supplierService.deleteSupplier(supplierID);
        SupplierDeleteRes supplierDeleteRes = new SupplierDeleteRes();
        supplierDeleteRes.setDeleteSuccess(true);

        return ResultUtil.success(supplierDeleteRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 新增客户
     */
    @PostMapping(value = "add")
    public Message addSupplier(@Valid @RequestBody SupplierAddReq supplierAddReq) {

        String name = supplierAddReq.getName();
        String address = supplierAddReq.getAddress();
        String phoneNumber = supplierAddReq.getPhoneNumber();
        Integer productNumber = supplierAddReq.getProductNumber();

        Supplier supplier = new Supplier(name, phoneNumber, address, productNumber);
        supplierService.addSupplier(supplier);

        SupplierAddRes supplierAddRes = new SupplierAddRes();
        supplierAddRes.setAddSuccess(true);

        return ResultUtil.success(supplierAddRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 根据 waterID 查找未给该矿泉水供货的供货商
     */
    @PostMapping(value = "getNotSupplier")
    public Message getNotSupplierList(@Valid @RequestBody GetNotSupplierListReq getNotSupplierListReq) {
        Integer waterID = getNotSupplierListReq.getWaterID();

        List<Supplier> supplierList = supplierService.getNotSupplierList(waterID);
        GetNotSupplierListRes getNotSupplierListRes = new GetNotSupplierListRes();
        getNotSupplierListRes.setSupplierList(supplierList);

        return ResultUtil.success(getNotSupplierListRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 根据 waterID 查找已经该矿泉水供货的供货商
     */
    @PostMapping(value = "getYetSupplier")
    public Message getYetSupplierList(@Valid @RequestBody GetNotSupplierListReq getNotSupplierListReq) {
        Integer waterID = getNotSupplierListReq.getWaterID();

        List<Supplier> supplierList = supplierService.getYetSupplierList(waterID);
        GetNotSupplierListRes getNotSupplierListRes = new GetNotSupplierListRes();
        getNotSupplierListRes.setSupplierList(supplierList);

        return ResultUtil.success(getNotSupplierListRes);
    }
}
