package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.bean.*;
import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.entity.Water;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 20:17
 */
@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    WaterService waterService;

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 获取矿泉水列表
     */
    @PostMapping(value = "getAll")
    public Message getAll() {

        List<WaterGetAllRes.Water> waterList = waterService.getAllWater();

        WaterGetAllRes waterGetAllRes = new WaterGetAllRes();
        waterGetAllRes.setWaterList(waterList);

        return ResultUtil.success(waterGetAllRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 删除矿泉水
     */
    @PostMapping(value = "delete")
    public Message deleteWater(@Valid @RequestBody WaterDeleteReq waterDeleteReq) {

        int waterID = waterDeleteReq.getWaterID();

        waterService.deleteWater(waterID);
        WaterDeleteRes waterDeleteRes = new WaterDeleteRes();
        waterDeleteRes.setDeleteSuccess(true);

        return ResultUtil.success(waterDeleteRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 新增矿泉水
     */
    @PostMapping(value = "add")
    public Message addWater(@Valid @RequestBody WaterAddReq waterAddReq) {

        String name = waterAddReq.getName();
        Integer size = waterAddReq.getSize();
        Integer cost = waterAddReq.getCost();
        Integer price = waterAddReq.getPrice();

        Water water = new Water(name, size, cost, price);
        waterService.addWater(water);

        WaterAddRes waterAddRes = new WaterAddRes();
        waterAddRes.setAddSuccess(true);

        return ResultUtil.success(waterAddRes);
    }
}
