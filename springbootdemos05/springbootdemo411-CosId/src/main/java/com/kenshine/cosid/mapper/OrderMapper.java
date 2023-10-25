package com.kenshine.cosid.mapper;

import com.kenshine.cosid.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author by kenshine
 * @Classname OrderMapper
 * @Description 用户Mapper
 * @Date 2023-10-25 9:45
 * @modified By：
 * @version: 1.0$
 *
 * extends BaseMapper<Order>
 */
@Mapper
public interface OrderMapper{
    @Insert("insert into order (order_id,user_id) value (#{orderId},#{userId});")
    void insert(Order order);
}
