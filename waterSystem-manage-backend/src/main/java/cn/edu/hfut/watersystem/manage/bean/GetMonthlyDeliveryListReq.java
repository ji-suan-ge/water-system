package cn.edu.hfut.watersystem.manage.bean;

/**
 * @author 葛学文
 * @date 2019/6/15 1:18
 */
public class GetMonthlyDeliveryListReq {
    private String year;
    private String month;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
