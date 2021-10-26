package com.kenshine.service.impl;

import com.kenshine.domain.User;
import com.kenshine.repository.UserRepository;
import com.kenshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 8:48
 * @description：用户Service实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //普通的缓存+数据库查询代码实现逻辑:
    //User user=RedisUtil.get(key);
    //   if(user==null){
    //        user=userDao.findById(id);
    //        //redis的key="product_item_"+id
    //        RedisUtil.set(key,user);
    //   }
    //   return user;

    /**
     *  注解@Cacheable:查询的时候才使用该注解!
     *  注意:在Cacheable注解中支持EL表达式
     *  redis缓存的key=user_1/2/3....
     *  redis的缓存雪崩,缓存穿透,缓存预热,缓存更新...
     *  condition = "#result ne null",条件表达式,当满足某个条件的时候才进行缓存
     *  unless = "#result eq null":当user对象为空的时候,不进行缓存
     */
    @Cacheable(value = "user", key = "#id", unless = "#result eq null")
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 注解@CachePut:一般用在添加和修改方法中
     * 既往数据库中添加一个新的对象,于此同时也往redis缓存中添加一个对应的缓存.
     * 这样可以达到缓存预热的目的.
     */
    @CachePut(value = "user", key = "#result.id", unless = "#result eq null")
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * CacheEvict:一般用在删除方法中
     */
    @CacheEvict(value = "user", key = "#id")
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
