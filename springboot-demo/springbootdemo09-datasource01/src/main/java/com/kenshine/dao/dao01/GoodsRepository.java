package com.kenshine.dao.dao01;

import com.kenshine.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:31
 * @description：商品dao
 * @modified By：
 * @version: $
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {
}
