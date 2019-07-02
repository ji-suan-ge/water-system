package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.entity.Custom;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 19:57
 */
public interface CustomService {
    List<Custom> getAllCustom();

    void deleteCustom(int customID);

    void addCustom(Custom custom);
}
