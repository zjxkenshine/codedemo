package com.kenshine.arangodb.repository;

import com.arangodb.ArangoCursor;
import com.arangodb.springframework.annotation.BindVars;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.annotation.QueryOptions;
import com.arangodb.springframework.repository.ArangoRepository;
import com.kenshine.arangodb.model.Character;
import org.springframework.data.repository.query.Param;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 22:34
 * @description：
 * @modified By：
 * @version: $
 */
public interface CharacterRepository extends ArangoRepository<Character, String> {
    Iterable<Character> findBySurname(String surname);

    Collection<Character> findTop2DistinctBySurnameIgnoreCaseOrderByAgeDesc(String surname);

    List<Character> findBySurnameEndsWithAndAgeBetweenAndNameInAllIgnoreCase(
            String suffix,
            int lowerBound,
            int upperBound,
            String[]nameList);

    Optional<Character> findByNameAndSurname(String name, String surname);

    Integer countByAliveTrue();

    void removeBySurnameNotLikeOrAliveFalse(String surname);

    //param注释
    @Query("FOR c IN characters FILTER c.surname == @surname SORT c.age ASC RETURN c")
    Iterable<Character> getWithSurname(@Param("surname") String value);

    //BindVars注释
    @Query("FOR c IN @@col FILTER c.surname == @surname AND c.age > @age RETURN c")
    Iterable<Character> getWithSurnameOlderThan(@Param("age") int value, @BindVars Map<String, Object> bindvars);

    //QueryOptions注解
    @Query("FOR c IN @@col FILTER c.surname == @surname AND c.age > @age RETURN c")
    @QueryOptions(count = true)
    ArangoCursor<Character> getWithSurnameOlderThan1(@Param("age") int value, @BindVars Map<String, Object> bindvars);

    //图遍历
    @Query("FOR v IN 1..2 INBOUND @arangoId @@edgeCol SORT v.age DESC RETURN DISTINCT v")
    Set<Character> getAllChildsAndGrandchilds(@Param("arangoId") String arangoId, @Param("@edgeCol") Class<?> edgeCollection);

}
