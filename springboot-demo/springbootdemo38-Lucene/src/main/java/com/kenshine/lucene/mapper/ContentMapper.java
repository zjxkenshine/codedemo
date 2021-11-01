package com.kenshine.lucene.mapper;

import com.kenshine.lucene.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 9:51
 * @description：内容Mapper
 * @modified By：
 * @version: $
 */
public interface ContentMapper extends JpaRepository<Content,Integer> {
}
