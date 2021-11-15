package test;

import com.kenshine.orient.OrientApp;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/15 22:59
 * @description：测试
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrientApp.class)
public class OrientTest {
    @Autowired
    private ODatabaseSession oDatabaseSession;

    @Test
    public void test(){
        // 创建顶点类Person和边类FriendOf
        createSchema(oDatabaseSession);
        // 插入数据
        createPeople(oDatabaseSession);
        // 执行查询语句
        executeAQuery(oDatabaseSession);
        // match查询
        executeAnotherQuery(oDatabaseSession);
    }

    private void createSchema(ODatabaseSession db) {
        OClass person = db.getClass("Person");

        if (person == null) {
            person = db.createVertexClass("Person");
        }

        if (person.getProperty("name") == null) {
            person.createProperty("name", OType.STRING);
            person.createIndex("Person_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
        }

        if (db.getClass("FriendOf") == null) {
            db.createEdgeClass("FriendOf");
        }

    }

    private void createPeople(ODatabaseSession db) {
        OVertex alice = createPerson(db, "Alice", "Foo");
        OVertex bob = createPerson(db, "Bob", "Bar");
        OVertex jim = createPerson(db, "Jim", "Baz");

        OEdge edge1 = alice.addEdge(bob, "FriendOf");
        edge1.save();
        OEdge edge2 = bob.addEdge(jim, "FriendOf");
        edge2.save();
    }

    private OVertex createPerson(ODatabaseSession db, String name, String surname) {
        OVertex result = db.newVertex("Person");
        result.setProperty("name", name);
        result.setProperty("surname", surname);
        result.save();
        return result;
    }

    private void executeAQuery(ODatabaseSession db) {
        String query = "SELECT expand(out('FriendOf').out('FriendOf')) from Person where name = ?";
        OResultSet rs = db.query(query, "Alice");

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("friend: " + item.getProperty("name"));
        }

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    private void executeAnotherQuery(ODatabaseSession db) {
        String query =
                " MATCH                                           " +
                        "   {class:Person, as:a, where: (name = :name1)}, " +
                        "   {class:Person, as:b, where: (name = :name2)}, " +
                        "   {as:a} -FriendOf-> {as:x} -FriendOf-> {as:b}  " +
                        " RETURN x.name as friend                         ";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name1", "Alice");
        params.put("name2", "Jim");

        OResultSet rs = db.query(query, params);

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("friend: " + item.getProperty("friend"));
        }

        rs.close();
    }


}
