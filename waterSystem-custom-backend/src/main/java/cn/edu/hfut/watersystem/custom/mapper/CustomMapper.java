package cn.edu.hfut.watersystem.custom.mapper;

import cn.edu.hfut.watersystem.custom.entity.Custom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author 葛学文
 * @date 2019/6/15 9:41
 */
@Mapper
public interface CustomMapper {

    @Select("CALL selectCustomByID(#{ID})")
    @Options(statementType= StatementType.CALLABLE)
    Custom selectCustom(int ID);

}
