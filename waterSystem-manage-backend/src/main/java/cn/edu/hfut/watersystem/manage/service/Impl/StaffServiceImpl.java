package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.Staff;
import cn.edu.hfut.watersystem.manage.mapper.StaffMapper;
import cn.edu.hfut.watersystem.manage.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 14:10
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;

    @Override
    public List<Staff> getAllStaff() {
        return staffMapper.selectAllStaff();
    }

    @Override
    public void deleteStaff(int staffID) {
        staffMapper.deleteStaff(staffID);
    }

    @Override
    public void editStaffSalary(int staffID, int salary) {
        staffMapper.updateStaffSalary(staffID, salary);
    }

    @Override
    public void addStaff(Staff staff) {
        staffMapper.insertStaff(staff);
    }
}
