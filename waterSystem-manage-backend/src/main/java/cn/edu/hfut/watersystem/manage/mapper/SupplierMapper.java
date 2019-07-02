package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.Supplier;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 21:32
 */
@Mapper
public interface SupplierMapper {
    @Select("CALL selectSupplier()")
    @Options(statementType= StatementType.CALLABLE)
    List<Supplier> selectAllSupplier();

    @Delete("CALL deleteSupplier(#{supplierID})")
    @Options(statementType= StatementType.CALLABLE)
    void deleteSupplier(int supplierID);

    @Insert("CALL insertSupplier(#{name}, #{phoneNumber}, #{address}, #{productNumber})")
    @Options(statementType= StatementType.CALLABLE)
    void insertSupplier(Supplier supplier);

    @Select("CALL selectNotSupplier(#{waterID})")
    @Options(statementType= StatementType.CALLABLE)
    List<Supplier> selectNotSupplierList(int waterID);

    @Select("CALL selectYetSupplier(#{waterID})")
    @Options(statementType= StatementType.CALLABLE)
    List<Supplier> selectYetSupplierList(int waterID);

}
