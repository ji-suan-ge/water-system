package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.MonthlyDelivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:10
 */
@Mapper
public interface MonthlyDeliveryMapper {

    @Select("CALL selectMonthlyDelivery(#{year}, #{month})")
    @Options(statementType= StatementType.CALLABLE)
    List<MonthlyDelivery> selectMonthlyDeliveryList(String year, String month);

}
