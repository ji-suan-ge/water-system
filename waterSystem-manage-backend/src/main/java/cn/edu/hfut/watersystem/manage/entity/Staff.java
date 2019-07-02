package cn.edu.hfut.watersystem.manage.entity;

/**
 * @author 葛学文
 * @date 2019/6/14 13:51
 */
public class Staff {
    private Integer ID;
    private String name;
    private Integer gender;
    private String dateOfEntry;
    private Integer salary;
    private String birthday;
    private Integer state;

    public Staff() {
    }

    public Staff(String name, Integer gender, String dateOfEntry, Integer salary, String birthday, Integer state) {
        this.name = name;
        this.gender = gender;
        this.dateOfEntry = dateOfEntry;
        this.salary = salary;
        this.birthday = birthday;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfEntry='" + dateOfEntry + '\'' +
                ", salary=" + salary +
                ", birthday='" + birthday + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
