package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.Custom;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 19:58
 */
@Mapper
public interface CustomMapper {
    @Select("CALL selectCustom()")
    @Options(statementType= StatementType.CALLABLE)
    List<Custom> selectAllCustom();

    @Delete("CALL deleteCustom(#{customID})")
    @Options(statementType= StatementType.CALLABLE)
    void deleteCustom(int customID);

    @Insert("CALL insertCustom(#{name}, #{gender}, #{address}, #{phoneNumber})")
    @Options(statementType= StatementType.CALLABLE)
    void insertCustom(Custom custom);
}
