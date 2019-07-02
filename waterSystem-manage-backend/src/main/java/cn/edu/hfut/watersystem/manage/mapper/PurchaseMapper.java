package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.Purchase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author 葛学文
 * @date 2019/6/15 0:31
 */
@Mapper
public interface PurchaseMapper {

    @Insert("CALL insertPurchase(#{waterID}, #{supplierID}, #{staffID}, #{quantity}, #{time})")
    @Options(statementType= StatementType.CALLABLE)
    void insertPurchase(Purchase purchase);

}
