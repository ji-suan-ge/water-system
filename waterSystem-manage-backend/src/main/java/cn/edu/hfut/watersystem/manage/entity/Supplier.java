package cn.edu.hfut.watersystem.manage.entity;

/**
 * @author 葛学文
 * @date 2019/6/14 21:29
 */
public class Supplier {
    private Integer ID;
    private String name;
    private String phoneNumber;
    private String address;
    private Integer productNumber;
    private Integer state;

    public Supplier() {
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", state=" + state +
                '}';
    }

    public Supplier(String name, String phoneNumber, String address, Integer productNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.productNumber = productNumber;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
