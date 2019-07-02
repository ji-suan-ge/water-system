package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author 葛学文
 * @date 2019/6/15 2:29
 */
@Mapper
public interface AdminMapper {
    @Select("CALL selectAdminByID(#{ID})")
    @Options(statementType= StatementType.CALLABLE)
    Admin selectAdmin(int ID);
}
