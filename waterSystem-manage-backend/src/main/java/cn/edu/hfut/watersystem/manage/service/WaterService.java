package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.bean.WaterGetAllRes;
import cn.edu.hfut.watersystem.manage.entity.Water;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 20:18
 */
public interface WaterService {

    List<WaterGetAllRes.Water> getAllWater();

    void deleteWater(int waterID);

    void addWater(Water water);
}
