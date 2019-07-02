package cn.edu.hfut.watersystem.manage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author 葛学文
 * @date 2019/6/14 23:53
 */
@Mapper
public interface SupplierWaterMapper {
    @Insert("CALL insertSupplierWater(#{supplierID}, #{waterID})")
    @Options(statementType= StatementType.CALLABLE)
    void insertSupplierWater(int supplierID, int waterID);

}
