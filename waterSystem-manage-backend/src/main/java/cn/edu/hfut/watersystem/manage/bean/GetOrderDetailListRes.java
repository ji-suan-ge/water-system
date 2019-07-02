package cn.edu.hfut.watersystem.manage.bean;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 8:34
 */
public class GetOrderDetailListRes {

    List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public static class OrderDetail {
        private Integer ID;
        private Integer customID;
        private Integer waterID;
        private Integer number;
        private String time;
        private Integer state;
        private String waterName;
        private String customName;

        public String getCustomName() {
            return customName;
        }

        public void setCustomName(String customName) {
            this.customName = customName;
        }

        public String getWaterName() {
            return waterName;
        }

        public void setWaterName(String waterName) {
            this.waterName = waterName;
        }

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
}
