package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Admin;
import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.mapper.AdminMapper;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.bean.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/6/15 2:25
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @PostMapping("/login")
    public Message login(@Valid @RequestBody LoginReq loginReq, HttpSession httpSession) {
        Integer ID = loginReq.getAdminID();
        String password = loginReq.getPassword();
        Admin admin = adminMapper.selectAdmin(ID);
        if (admin == null || !password.equals(admin.getPassword())) return ResultUtil.error("密码错误");
        httpSession.setAttribute("admin", admin);
        return ResultUtil.success("登陆成功");
    }

    @PostMapping("/isLogin")
    public Message isLogin(HttpSession httpSession) {
        Object obj = httpSession.getAttribute("admin");
        if (obj == null) return ResultUtil.error("Not");
        return ResultUtil.success("OK");
    }
}
