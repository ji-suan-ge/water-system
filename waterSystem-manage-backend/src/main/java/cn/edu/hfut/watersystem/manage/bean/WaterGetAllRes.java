package cn.edu.hfut.watersystem.manage.bean;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 20:21
 */
public class WaterGetAllRes {
    private List<Water> waterList;

    public List<Water> getWaterList() {
        return waterList;
    }

    public void setWaterList(List<Water> waterList) {
        this.waterList = waterList;
    }

    public static class Water {
        private Integer ID;
        private String name;
        private Integer size;
        private Integer cost;
        private Integer price;
        private Integer state;
        private Integer quantity;

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

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
