package com.kenshine.arangodb.web;

import com.arangodb.springframework.core.ArangoOperations;
import com.kenshine.arangodb.model.Character;
import com.kenshine.arangodb.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.StreamSupport;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 22:18
 * @description： ArangoDB CRUD
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class CharacterController {

    @Autowired
    private ArangoOperations operations;
    @Autowired
    private CharacterRepository repository;

    /**
     * 1. 保存和读取实体类
     */
    @GetMapping("/test01")
    public Character test01_SaveAndReadEntity(){
        //删除存储库
        operations.dropDatabase();

        // 创建一个实体并保存
        final Character nedStark = new Character("Ned", "Stark", true, 41);
        repository.save(nedStark);
        System.out.println(String.format("Ned Stark saved in the database with id: '%s'", nedStark.getId()));

        // 查询实体文档
        final Optional<Character> foundNed = repository.findById(nedStark.getId());
        assert foundNed.isPresent();
        System.out.println(String.format("Found %s", foundNed.get()));
        return foundNed.get();
    }


    /**
     * 2. 更新实体
     */
    @GetMapping("/test02")
    public Character test02_UpdateEntity(){
        final Character nedStark = new Character("Ned", "Stark", true, 41);
        nedStark.setAlive(false);
        repository.save(nedStark);
        final Optional<Character> deadNed = repository.findById(nedStark.getId());
        assert deadNed.isPresent();
        System.out.println(String.format("The 'alive' flag of the persisted Ned Stark is now '%s'",deadNed.get().isAlive()));
        return deadNed.get();
    }

    /**
     * 3.保存和读取多个实体
     */
    @GetMapping("/test03")
    public void test03_MultiEntity(){
        Collection<Character> createCharacters = createCharacters();
        System.out.println(String.format("Save %s additional chracters",createCharacters.size()));
        repository.saveAll(createCharacters);

        Iterable<Character> all = repository.findAll();
        long count= StreamSupport.stream(Spliterators.spliteratorUnknownSize(all.iterator(),0),false).count();
        System.out.println(String.format("A total of %s characters are persisted in the database",count));
    }

    /**
     * 4.排序与分页
     */
    @GetMapping("/test04")
    public void test04_SortAndPage(){
        System.out.println("## Return the first 5 characters sorted by name");
        Page<Character> first5Sorted = repository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "name")));
        first5Sorted.forEach(System.out::println);
    }

    /**
     * 5.查询单个实体 使用Example
     */
    @GetMapping("/test05")
    public void test05_SingleQuery(){
        //查询
        final Character nedStark=new Character("Ned", "Stark", false, 41);
        System.out.println(String.format("## Find character which exactly match %s",nedStark));
        Optional<Character> foundNedStark = repository.findOne(Example.of(nedStark));
        assert foundNedStark.isPresent();
        System.out.println(String.format("Found %s", foundNedStark.get()));
    }

    /**
     * 6.查询多个实体
     */
    @GetMapping("/test06")
    public void test06_MultiQuery(){
        System.out.println("## Find all dead Starks");
        Iterable<Character> allDeadStarks = repository
                .findAll(Example.of(new Character(null, "Stark", false), ExampleMatcher.matchingAll()
                        .withMatcher("surname", ExampleMatcher.GenericPropertyMatcher::exact).withIgnorePaths("name", "age")));
        allDeadStarks.forEach(System.out::println);

//        System.out.println("## Find all Starks which are 30 years younger than Ned Stark");
//        Iterable<Character> allYoungerStarks = repository.findAll(
//                Example.of(foundNedStark.get(), ExampleMatcher.matchingAll()
//                        .withMatcher("surname", ExampleMatcher.GenericPropertyMatcher::exact)
//                        .withIgnorePaths("id", "name", "alive")
//                        .withTransformer("age", age -> age.map(it -> (int) it - 30))));
//        allYoungerStarks.forEach(System.out::println);
    }

    /**
     * 7.简单findby
     */
    @GetMapping("/test07")
    public void test07_SimpleFindby(){
        System.out.println("# Derived queries");
        System.out.println("## Find all characters with surname 'Lannister'");
        Iterable<Character> lannisters = repository.findBySurname("Lannister");
        lannisters.forEach(System.out::println);
    }

    /**
     * 8.复杂findby
     */
    @GetMapping("/test08")
    public void test08_MultiFindBy(){
        System.out.println("## Find top 2 Lannnisters ordered by age");
        Collection<Character> top2 = repository.findTop2DistinctBySurnameIgnoreCaseOrderByAgeDesc("lannister");
        top2.forEach(System.out::println);

        System.out.println("## Find all characters which name is 'Bran' or 'Sansa' and it's surname ends with 'ark' and are between 10 and 16 years old");
        List<Character> youngStarks = repository.findBySurnameEndsWithAndAgeBetweenAndNameInAllIgnoreCase("ark", 10, 16, new String[]{"Bran", "Sansa"});
        youngStarks.forEach(System.out::println);
    }

    /**
     * 9.单个实体结果
     */
    @GetMapping("/test09")
    public void test09_FindSingle(){
        System.out.println("## Find a single character by name & surname");
        Optional<Character> tyrion = repository.findByNameAndSurname("Tyrion", "Lannister");
        tyrion.ifPresent(c -> System.out.println(String.format("Found %s", c)));
    }

    /**
     * 10.countBy计数
     */
    @GetMapping("/test10")
    public void test10_CountBy(){
        System.out.println("## Count how many characters are still alive");
        Integer alive = repository.countByAliveTrue();
        System.out.println(String.format("There are %s characters still alive", alive));
    }

    /**
     * 11.removeBy删除
     */
    @GetMapping("/test11")
    public void test11_removeBy(){
        System.out.println("## Remove all characters except of which surname is 'Stark' and which are still alive");
        repository.removeBySurnameNotLikeOrAliveFalse("Stark");
        repository.findAll().forEach(System.out::println);
    }












    public static Collection<Character> createCharacters(){
        return Arrays.asList(new Character("Robert","Baratheon",false),
                new Character("Jaime","Lannister",true,36),new Character("Catelyn","Stark",false,40),
                new Character("Cersei","Lannister",true,36),new Character("Daenerys","Targaryen",true,16),
                new Character("Jorah","Mormont",false),new Character("Petyr","Baelish",false),
                new Character("Viserys","Targaryen",false),new Character("Jon","Snow",true,16),
                new Character("Sansa","Stark",true,13),new Character("Arya","Stark",true,11),
                new Character("Robb","Stark",false),new Character("Theon","Greyjoy",true,16),
                new Character("Bran","Stark",true,10),new Character("Joffrey","Baratheon",false,19),
                new Character("Sandor","Clegane",true),new Character("Tyrion","Lannister",true,32),
                new Character("Khal","Drogo",false),new Character("Tywin","Lannister",false),
                new Character("Davos","Seaworth",true,49),new Character("Samwell","Tarly",true,17),
                new Character("Stannis","Baratheon",false),new Character("Melisandre",null,true),
                new Character("Margaery","Tyrell",false),new Character("Jeor","Mormont",false),
                new Character("Bronn",null,true),new Character("Varys",null,true),new Character("Shae",null,false),
                new Character("Talisa","Maegyr",false),new Character("Gendry",null,false),
                new Character("Ygritte",null,false),new Character("Tormund","Giantsbane",true),
                new Character("Gilly",null,true),new Character("Brienne","Tarth",true,32),
                new Character("Ramsay","Bolton",true),new Character("Ellaria","Sand",true),
                new Character("Daario","Naharis",true),new Character("Missandei",null,true),
                new Character("Tommen","Baratheon",true),new Character("Jaqen","H'ghar",true),
                new Character("Roose","Bolton",true),new Character("The High Sparrow",null,true));
    }

}
