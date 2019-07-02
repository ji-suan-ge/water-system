package cn.edu.hfut.watersystem.manage.entity;

/**
 * @author 葛学文
 * @date 2019/6/14 20:15
 */
public class Water {
    private Integer ID;
    private String name;
    private Integer size;
    private Integer cost;
    private Integer price;
    private Integer state;

    public Water() {
    }

    public Water(String name, Integer size, Integer cost, Integer price) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.price = price;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
