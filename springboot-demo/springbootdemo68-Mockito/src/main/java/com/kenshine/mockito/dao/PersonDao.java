package com.kenshine.mockito.dao;

import com.kenshine.mockito.domain.Person;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 13:48
 * @description：用户Dao
 * @modified By：
 * @version: $
 *
 * 模拟连接数据库操作
 */
@Component
public class PersonDao {

    public Person getPerson(int id){
        return new Person().setId(id).setName("kenshine");
    }

    /**
     * 更新
     * @param person
     * @return
     */
    public boolean update(Person person){
        System.out.println("更新成功");
        return true;
    }

    /**
     * 无返回值方法
     */
    public void clear(){
        System.out.println("调用了clear");
    }

}
