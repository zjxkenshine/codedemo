package com.kenshine.trans.mapper;

import com.kenshine.trans.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/21 21:39
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper
public interface AccountMapper {

    @Select("select * from account where account_id=1")
    Account getAccount();

    @Update("update account set balance = balance+100 where account_id=1")
    void addMoney();
}
