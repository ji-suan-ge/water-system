package cn.edu.hfut.watersystem.manage.entity;

/**
 * @author 葛学文
 * @date 2019/6/15 2:29
 */
public class Admin {
    private Integer ID;
    private String name;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
