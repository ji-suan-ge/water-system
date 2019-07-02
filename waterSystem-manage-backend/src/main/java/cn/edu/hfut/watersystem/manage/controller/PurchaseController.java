package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.entity.Purchase;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.bean.AddPurchaseReq;
import cn.edu.hfut.watersystem.manage.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 葛学文
 * @date 2019/6/15 0:37
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/add")
    public Message addPurchase(@Valid @RequestBody AddPurchaseReq addPurchaseReq) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Purchase purchase = new Purchase(addPurchaseReq.getWaterID(),
                addPurchaseReq.getSupplierID(),
                addPurchaseReq.getStaffID(),
                addPurchaseReq.getQuantity(),
                time);

        purchaseService.addPurchase(purchase);

        return ResultUtil.success("成功");
    }
}
