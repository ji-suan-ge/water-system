package cn.edu.hfut.watersystem.custom.util;


import cn.edu.hfut.watersystem.custom.entity.Message;

/**
 * @author 徐庶博
 * @date 2019/4/2 22:20
 */
public class ResultUtil {

    public ResultUtil(){
    }

    /**
     * 接口请求成功返回
     * @param object
     * @return
     */
    public static Message success(Object object){
        Message message = new Message();
        message.setCode("0000");
        message.setMsg("请求成功");
        message.setData(object);
        return message;
    }

    /**
     * 接口请求失败返回
     * @param resultMessage
     * @return
     */
    public static Message error(String resultMessage){
        Message message = new Message();
        message.setCode("4000");
        message.setMsg(resultMessage);
        return message;
    }
}
