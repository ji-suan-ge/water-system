package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.bean.WaterGetAllRes;
import cn.edu.hfut.watersystem.manage.entity.Water;
import cn.edu.hfut.watersystem.manage.mapper.WaterMapper;
import cn.edu.hfut.watersystem.manage.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 20:19
 */
@Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    WaterMapper waterMapper;

    @Override
    public List<WaterGetAllRes.Water> getAllWater() {
        return waterMapper.selectAllWater();
    }

    @Override
    public void deleteWater(int waterID) {
        waterMapper.deleteWater(waterID);
    }

    @Override
    public void addWater(Water water) {
        waterMapper.insertWater(water);
    }
}
