package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 14:04
 */
@Mapper
public interface StaffMapper {
    @Select("CALL selectStaff()")
    @Options(statementType= StatementType.CALLABLE)
    List<Staff> selectAllStaff();

    @Delete("CALL deleteStaff(#{staffID})")
    @Options(statementType= StatementType.CALLABLE)
    void deleteStaff(int staffID);


    @Update("CALL updateStaffSalary(#{staffID}, #{salary})")
    @Options(statementType= StatementType.CALLABLE)
    void updateStaffSalary(int staffID, int salary);

    @Insert("CALL insertStaff(#{name}, #{gender}, #{dateOfEntry}, #{salary}, #{birthday})")
    @Options(statementType= StatementType.CALLABLE)
    void insertStaff(Staff staff);
}
