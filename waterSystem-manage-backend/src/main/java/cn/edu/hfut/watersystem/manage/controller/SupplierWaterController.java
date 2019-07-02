package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.bean.AddSupplierWaterReqBean;
import cn.edu.hfut.watersystem.manage.bean.AddSupplierWaterRes;
import cn.edu.hfut.watersystem.manage.service.SupplierWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/6/14 23:58
 */
@RestController
@RequestMapping("/supplierWater")
public class SupplierWaterController {
    @Autowired
    SupplierWaterService supplierWaterService;

    @PostMapping("/add")
    public Message addSupplierWater(@Valid @RequestBody AddSupplierWaterReqBean addSupplierWaterReqBean) {
        int supplierID = addSupplierWaterReqBean.getSupplierID();
        int waterID = addSupplierWaterReqBean.getWaterID();

        supplierWaterService.addSupplierWater(supplierID, waterID);
        AddSupplierWaterRes addSupplierWaterRes = new AddSupplierWaterRes();
        addSupplierWaterRes.setAddSuccess(true);

        return ResultUtil.success(addSupplierWaterRes);
    }
}
