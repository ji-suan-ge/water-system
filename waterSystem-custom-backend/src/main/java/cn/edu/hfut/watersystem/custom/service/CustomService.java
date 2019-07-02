package cn.edu.hfut.watersystem.custom.service;

import cn.edu.hfut.watersystem.custom.entity.Custom;
import cn.edu.hfut.watersystem.custom.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 葛学文
 * @date 2019/6/15 9:42
 */
@Service
public class CustomService {

    @Autowired
    CustomMapper customMapper;

    public Custom getCustomByID(int id) {
        return customMapper.selectCustom(id);
    }
}
