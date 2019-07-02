package cn.edu.hfut.watersystem.manage.bean;

/**
 * @author 葛学文
 * @date 2019/6/14 17:00
 */
public class StaffAddReq {
    private String name;
    private Integer gender;
    private Integer salary;
    private String birthday;

    @Override
    public String toString() {
        return "StaffAddReq{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
