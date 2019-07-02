package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.bean.*;
import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.entity.Staff;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 14:04
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 获取员工列表
     */
    @PostMapping(value = "getAll")
    public Message getAll() {

        List<Staff> staffList = staffService.getAllStaff();

        StaffGetAllRes staffGetAllRes = new StaffGetAllRes();
        staffGetAllRes.setStaffList(staffList);

        return ResultUtil.success(staffGetAllRes);
    }


    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 删除员工
     */
    @PostMapping(value = "delete")
    public Message deleteStaff(@Valid @RequestBody StaffDeleteReq staffDeleteReq) {

        int staffID = staffDeleteReq.getStaffID();

        staffService.deleteStaff(staffID);
        StaffDeleteRes staffDeleteRes = new StaffDeleteRes();
        staffDeleteRes.setDeleteSuccess(true);
        return ResultUtil.success(staffDeleteRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 修改员工工资
     */
    @PostMapping(value = "editSalary")
    public Message editStaffSalary(@Valid @RequestBody StaffSalaryEditReq staffSalaryEditReq) {

        int staffID = staffSalaryEditReq.getStaffID();
        int salary = staffSalaryEditReq.getSalary();

        staffService.editStaffSalary(staffID, salary);
        StaffSalaryEditRes staffSalaryEditRes = new StaffSalaryEditRes();
        staffSalaryEditRes.setEditSuccess(true);
        return ResultUtil.success(staffSalaryEditRes);
    }

    /**
     * @author 葛学文
     * @date 2019/6/14 14:04
     * 新增员工
     */
    @PostMapping(value = "add")
    public Message addStaff(@Valid @RequestBody StaffAddReq staffAddReq) {

        int salary = staffAddReq.getSalary();
        String name = staffAddReq.getName();
        Integer gender = staffAddReq.getGender();
        String birthday = staffAddReq.getBirthday();
        Integer state = 1;
        String dateOfEntry = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Staff staff = new Staff(name, gender, dateOfEntry, salary, birthday, state);


        staffService.addStaff(staff);

        StaffAddRes staffAddRes = new StaffAddRes();
        staffAddRes.setAddSuccess(true);

        return ResultUtil.success(staffAddRes);
    }
}
