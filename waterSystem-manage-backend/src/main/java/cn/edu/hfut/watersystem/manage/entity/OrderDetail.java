package cn.edu.hfut.watersystem.manage.entity;

/**
 * @author 葛学文
 * @date 2019/6/15 8:22
 */
public class OrderDetail {
    private Integer ID;
    private Integer customID;
    private Integer waterID;
    private Integer number;
    private String time;
    private Integer state;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }

    public Integer getWaterID() {
        return waterID;
    }

    public void setWaterID(Integer waterID) {
        this.waterID = waterID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
