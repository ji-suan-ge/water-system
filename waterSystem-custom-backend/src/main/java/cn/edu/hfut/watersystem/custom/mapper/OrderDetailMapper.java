package cn.edu.hfut.watersystem.custom.mapper;

import cn.edu.hfut.watersystem.custom.entity.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author 葛学文
 * @date 2019/6/15 8:25
 */
@Mapper
public interface OrderDetailMapper {

    @Insert("CALL insertOrderdetail(#{customID}, #{waterID}, #{number}, #{time})")
    @Options(statementType= StatementType.CALLABLE)
    void insertOrderDetail(OrderDetail orderDetail);
}
