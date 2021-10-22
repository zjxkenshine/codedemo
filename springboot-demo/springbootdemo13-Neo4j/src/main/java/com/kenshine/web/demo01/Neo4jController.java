package com.kenshine.web.demo01;

import com.kenshine.entity.demo01.ParentNode;
import com.kenshine.entity.demo01.RelationNode;
import com.kenshine.entity.demo01.SonNode;
import com.kenshine.repository.demo01.ParentRepository;
import com.kenshine.repository.demo01.RelationNodeRepository;
import com.kenshine.repository.demo01.SonNodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:16
 * @description：Neo4jController
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("/node")
@Slf4j
public class Neo4jController {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private RelationNodeRepository relationNodeRepository;

    @Autowired
    private SonNodeRepository sonNodeRepository;

    @GetMapping(value = "/create")
    public void createNodeRelation() {
        SonNode sonNode1 = new SonNode("儿子小帅");
        SonNode sonNode2 = new SonNode("女儿小美");

        ParentNode parentNode = new ParentNode("爸爸:孙一一");

        addSon(parentNode,sonNode1, "女儿");
        addSon(parentNode,sonNode2, "儿子");

        parentRepository.save(parentNode);
        sonNodeRepository.save(sonNode1);
        sonNodeRepository.save(sonNode2);
    }

    private void addSon(ParentNode parentNode,SonNode sonNode, String name) {
        RelationNode relationNode = new RelationNode(parentNode, name, sonNode);
        parentNode.getSets().add(sonNode);
        relationNodeRepository.save(relationNode);
    }

    @GetMapping(value = "/find")
    public void findNodes() {

    }

}
