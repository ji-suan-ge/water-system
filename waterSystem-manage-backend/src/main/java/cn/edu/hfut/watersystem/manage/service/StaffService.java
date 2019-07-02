package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.entity.Staff;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 14:09
 */
public interface StaffService {

    List<Staff> getAllStaff();

    void deleteStaff(int staffID);

    void editStaffSalary(int staffID, int salary);

    void addStaff(Staff staff);

}
