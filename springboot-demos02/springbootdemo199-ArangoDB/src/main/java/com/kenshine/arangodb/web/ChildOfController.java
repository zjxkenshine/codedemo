package com.kenshine.arangodb.web;

import com.arangodb.ArangoCursor;
import com.arangodb.springframework.core.ArangoOperations;
import com.kenshine.arangodb.model.Character;
import com.kenshine.arangodb.model.ChildOf;
import com.kenshine.arangodb.repository.CharacterRepository;
import com.kenshine.arangodb.repository.ChildOfRepository;
import com.kenshine.arangodb.runner.CrudRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 23:19
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/edge")
public class ChildOfController {

    @Autowired
    private ArangoOperations operations;
    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private ChildOfRepository childOfRepo;

    /**
     * 初始化
     */
    @GetMapping("/init")
    public void init(){
        System.out.println("# Relations");
        characterRepo.saveAll(CharacterController.createCharacters());

        // 创建一些关系
        characterRepo.findByNameAndSurname("Ned", "Stark").ifPresent(ned -> {
            characterRepo.findByNameAndSurname("Catelyn", "Stark").ifPresent(catelyn -> {
                characterRepo.findByNameAndSurname("Robb", "Stark").ifPresent(robb -> childOfRepo.saveAll(Arrays.asList(new ChildOf(robb, ned), new ChildOf(robb, catelyn))));
                characterRepo.findByNameAndSurname("Sansa", "Stark").ifPresent(sansa -> childOfRepo.saveAll(Arrays.asList(new ChildOf(sansa, ned), new ChildOf(sansa, catelyn))));
                characterRepo.findByNameAndSurname("Arya", "Stark").ifPresent(arya -> childOfRepo.saveAll(Arrays.asList(new ChildOf(arya, ned), new ChildOf(arya, catelyn))));
                characterRepo.findByNameAndSurname("Bran", "Stark").ifPresent(bran -> childOfRepo.saveAll(Arrays.asList(new ChildOf(bran, ned), new ChildOf(bran, catelyn))));
            });
            characterRepo.findByNameAndSurname("Jon", "Snow")
                    .ifPresent(bran -> childOfRepo.save(new ChildOf(bran, ned)));
        });

        characterRepo.findByNameAndSurname("Tywin", "Lannister").ifPresent(tywin -> {
            characterRepo.findByNameAndSurname("Jaime", "Lannister").ifPresent(jaime -> {
                childOfRepo.save(new ChildOf(jaime, tywin));
                characterRepo.findByNameAndSurname("Cersei", "Lannister").ifPresent(cersei -> {
                    childOfRepo.save(new ChildOf(cersei, tywin));
                    characterRepo.findByNameAndSurname("Joffrey", "Baratheon").ifPresent(joffrey -> childOfRepo.saveAll(Arrays.asList(new ChildOf(joffrey, jaime), new ChildOf(joffrey, cersei))));
                });
            });
            characterRepo.findByNameAndSurname("Tyrion", "Lannister")
                    .ifPresent(tyrion -> childOfRepo.save(new ChildOf(tyrion, tywin)));
        });
    }

    /**
     * 1.读取某实体关系
     */
    @GetMapping("/test01")
    public void test01_ReadEntity(){
        characterRepo.findByNameAndSurname("Ned", "Stark").ifPresent(nedStark -> {
            System.out.println(String.format("## These are the childs of %s:", nedStark));
            nedStark.getChilds().forEach(System.out::println);
        });
    }

    /**
     * 2.参数注解查询 AQL语句
     */
    @GetMapping("/test02")
    public void test02_Param(){
        System.out.println("## Find all characters with surname 'Lannister' (sort by age ascending)");
        Iterable<Character> lannisters = characterRepo.getWithSurname("Lannister");
        lannisters.forEach(System.out::println);
    }

    /**
     * 3.BindVars注解
     */
    @GetMapping("/test03")
    public void test03_BindVars(){
        System.out.println("## Find all characters with surname 'Lannister' which are older than 35");
        Map<String, Object> bindvars = new HashMap<>();
        bindvars.put("surname", "Lannister");
        bindvars.put("@col", Character.class);
        Iterable<Character> oldLannisters = characterRepo.getWithSurnameOlderThan(35, bindvars);
        oldLannisters.forEach(System.out::println);
    }

    /**
     * 4.QueryOptions注解
     * 设置批处理大小
     */
    @GetMapping("/test04")
    public void test04_BindVars(){
        Map<String, Object> bindvars = new HashMap<>();
        bindvars.put("surname", "Lannister");
        bindvars.put("@col", Character.class);
        ArangoCursor<Character> oldLannisters = characterRepo.getWithSurnameOlderThan1(35, bindvars);
        System.out.println(String.format("Found %s documents", oldLannisters.getCount()));
        oldLannisters.forEach(System.out::println);
    }

    /**
     * 5.图遍历
     */
    @GetMapping("/test05")
    public void test05_GraphTraversal(){
        System.out.println("## Find all childs and grantchilds of 'Tywin Lannister' (sort by age descending)");
        characterRepo.findByNameAndSurname("Tywin", "Lannister").ifPresent(tywin -> {
            Set<Character> childs = characterRepo.getAllChildsAndGrandchilds(tywin.getArangoId(), ChildOf.class);
            childs.forEach(System.out::println);
        });
    }


}
