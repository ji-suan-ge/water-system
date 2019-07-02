package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 葛学文
 * @date 2019/6/15 1:59
 */
@RestController
@RequestMapping("/backup")
public class BackupController {

    @PostMapping("/get")
    private Message get() {
        String fileName = "/tmp/waterSystem" + new java.util.Date().getTime() + ".sql";
        String cmd = "mysqldump -uroot -ppro888 waterSystem > " +  fileName;
        System.out.println(cmd);
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            System.out.println("success!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.success("OK");
    }
}
