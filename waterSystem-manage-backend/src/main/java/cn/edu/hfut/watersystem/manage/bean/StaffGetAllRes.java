package cn.edu.hfut.watersystem.manage.bean;

import cn.edu.hfut.watersystem.manage.entity.Staff;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 14:21
 */
public class StaffGetAllRes {
    private List<Staff> staffList;

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
