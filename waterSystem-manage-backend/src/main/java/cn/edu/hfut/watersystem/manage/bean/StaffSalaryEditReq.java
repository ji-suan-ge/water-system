package cn.edu.hfut.watersystem.manage.bean;

/**
 * @author 葛学文
 * @date 2019/6/14 15:24
 */
public class StaffSalaryEditReq {
    private Integer staffID;
    private Integer salary;

    @Override
    public String toString() {
        return "StaffSalaryEditReq{" +
                "staffID=" + staffID +
                ", salary=" + salary +
                '}';
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
