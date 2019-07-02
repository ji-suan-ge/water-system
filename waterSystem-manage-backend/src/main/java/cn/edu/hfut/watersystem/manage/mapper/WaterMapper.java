package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.Water;
import cn.edu.hfut.watersystem.manage.bean.WaterGetAllRes;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 20:17
 */
@Mapper
public interface WaterMapper {

    @Select("CALL selectWater()")
    @Options(statementType = StatementType.CALLABLE)
    List<WaterGetAllRes.Water> selectAllWater();


    @Delete("CALL deleteWater(#{WaterID})")
    @Options(statementType= StatementType.CALLABLE)
    void deleteWater(int WaterID);

    @Insert("CALL insertWater(#{name}, #{size}, #{cost}, #{price})")
    @Options(statementType= StatementType.CALLABLE)
    void insertWater(Water water);
}
