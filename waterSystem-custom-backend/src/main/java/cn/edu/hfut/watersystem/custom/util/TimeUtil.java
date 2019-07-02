package cn.edu.hfut.watersystem.custom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 葛学文
 * @date 2019/4/20 11:19
 */
public class TimeUtil {
    public static String getFormatTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * @author 葛学文
     * @date 2019/4/25
     * 比较 time1 和 time2 ，若time1 更早，则返回 true
     */
    public static boolean CompareTime(String time1, String time2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.parse(time1).before(sdf.parse(time2));
    }
}
