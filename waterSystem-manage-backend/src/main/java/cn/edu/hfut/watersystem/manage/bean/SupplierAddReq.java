package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/14 21:43
 */
public class SupplierAddReq {
    @NotNull(message = "name 不能为空")
    private String name;
    @NotNull(message = "phoneNumber 不能为空")
    private String phoneNumber;
    @NotNull(message = "address 不能为空")
    private String address;
    @NotNull(message = "productNumber 不能为空")
    private Integer productNumber;

    @Override
    public String toString() {
        return "SupplierAddReq{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", productNumber=" + productNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
}
