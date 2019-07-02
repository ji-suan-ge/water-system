package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.bean.*;
import cn.edu.hfut.watersystem.manage.entity.Custom;
import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 17:39
 */
@RestController
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 获取客户列表
     */
    @PostMapping(value = "/getAll")
    public Message getAll() {

        List<Custom> customList = customService.getAllCustom();

        CustomGetAllRes customGetAllRes = new CustomGetAllRes();
        customGetAllRes.setCustomList(customList);

        return ResultUtil.success(customGetAllRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 删除客户
     */
    @PostMapping(value = "delete")
    public Message deleteCustom(@Valid @RequestBody CustomDeleteReq customDeleteReq) {

        int customID = customDeleteReq.getCustomID();

        customService.deleteCustom(customID);
        CustomDeleteRes customDeleteRes = new CustomDeleteRes();
        customDeleteRes.setDeleteSuccess(true);

        return ResultUtil.success(customDeleteRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 新增客户
     */
    @PostMapping(value = "add")
    public Message addCustom(@Valid @RequestBody CustomAddReq customAddReq) {

        String name = customAddReq.getName();
        Integer gender = customAddReq.getGender();
        String address = customAddReq.getAddress();
        String phoneNumber = customAddReq.getPhoneNumber();

        Custom custom = new Custom(name, gender, address, phoneNumber);
        customService.addCustom(custom);

        CustomAddRes customAddRes = new CustomAddRes();
        customAddRes.setAddSuccess(true);

        return ResultUtil.success(customAddRes);
    }
}
