package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/14 20:56
 */
public class WaterAddReq {
    @NotNull(message = "name 不能为空")
    private String name;
    @NotNull(message = "size 不能为空")
    private Integer size;
    @NotNull(message = "cost 不能为空")
    private Integer cost;
    @NotNull(message = "price 不能为空")
    private Integer price;

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
}
