package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.Custom;
import cn.edu.hfut.watersystem.manage.mapper.CustomMapper;
import cn.edu.hfut.watersystem.manage.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 19:58
 */
@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> getAllCustom() {
        return customMapper.selectAllCustom();
    }

    @Override
    public void deleteCustom(int customID) {
        customMapper.deleteCustom(customID);
    }

    @Override
    public void addCustom(Custom custom) {
        customMapper.insertCustom(custom);
    }
}
