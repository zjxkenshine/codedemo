package jsonpath;

import com.jayway.jsonpath.*;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import com.kenshine.jsonpath.domain.Book;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/26 21:38
 * @description：jsonpath测试
 * @modified By：
 * @version: $
 */
public class JSonPathTest {
    private static String json = null;

    static {
        try {
            StringBuffer str = new StringBuffer();
            readToBuffer(str,"src\\main\\resources\\json\\test.json");
            json=str.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }


    /**
     * 1.读取json字符的三种方式
     */
    @Test
    public void test01_ReadJson(){
        //读取方式一 JsonPath.read
        List<String> authors = JsonPath.read(json, "$.store.book[*].author");
        System.out.println(authors);

        //读取方式二 Configuration.path
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        String author0 = JsonPath.read(document, "$.store.book[0].author");
        String author1 = JsonPath.read(document, "$.store.book[1].author");
        System.out.println(author0+"|"+author1);

        //读取方式三 ReadContext
        ReadContext ctx = JsonPath.parse(json);
        List<String> authorsOfBooksWithISBN = ctx.read("$.store.book[?(@.isbn)].author");
        List expensiveBooks = JsonPath
                .using(Configuration.defaultConfiguration())
                .parse(json)
                .read("$.store.book[?(@.price > 10)]", List.class);
        System.out.println(authorsOfBooksWithISBN);
        System.out.println(expensiveBooks);
    }

    /**
     * 2.指定返回类型
     */
    @Test
    public void test02_ReturnType(){
        String json1 = "{\"date_as_long\" : 1411455611975}";
        Date date = JsonPath.parse(json1).read("$['date_as_long']", Date.class);
        System.out.println(date);

        Book book = JsonPath.parse(json).read("$.store.book[0]", Book.class);
        System.out.println(book);

        //默认的Json-smart provider不能解析TypeRef 需要使用Jackson或者Gson
        TypeRef<List<String>> typeRef = new TypeRef<List<String>>() {};
        Configuration.setDefaults(new Configuration.Defaults() {
            private final JsonProvider jsonProvider = new JacksonJsonProvider();
            private final MappingProvider mappingProvider = new JacksonMappingProvider();
            @Override
            public JsonProvider jsonProvider() {
                return jsonProvider;
            }

            @Override
            public MappingProvider mappingProvider() {
                return mappingProvider;
            }

            @Override
            public Set<Option> options() {
                return EnumSet.noneOf(Option.class);
            }
        });
        List<String> titles = JsonPath.parse(json).read("$.store.book[*].title", typeRef);
        System.out.println(titles);
    }

    /**
     * 谓词
     */
    @Test
    public void test03_Predicate(){
        List<Map<String, Object>> books1 =  JsonPath.parse(json)
                .read("$.store.book[?(@.price < 10)]");
        System.out.println(books1);

        Filter cheapFictionFilter = Filter.filter(Criteria.where("category").is("fiction").and("price").lte(10D));
        List<Map<String, Object>> books2 = JsonPath.parse(json).read("$.store.book[?]", cheapFictionFilter);
        System.out.println(books2);

        //自定义过滤器
        Predicate booksWithISBN = new Predicate() {
            @Override
            public boolean apply(PredicateContext ctx) {
                return ctx.item(Map.class).containsKey("isbn");
            }
        };
        List books3 = JsonPath.parse(json).read("$.store.book[?].isbn", List.class, booksWithISBN);
        System.out.println(books3);
    }

    /**
     * 返回路径或值
     */
    @Test
    public void test04(){
        Configuration conf = Configuration.builder()
                .options(Option.AS_PATH_LIST).build();

        List<String> pathList = JsonPath.using(conf).parse(json).read("$..author");

        assertThat(pathList).containsExactly(
                "$['store']['book'][0]['author']",
                "$['store']['book'][1]['author']",
                "$['store']['book'][2]['author']",
                "$['store']['book'][3]['author']");
    }


    /**
     * 5. 设置一个值
     */
    @Test
    public void test05_SetAValue(){
        String newJson = JsonPath.parse(json).set("$['store']['book'][0]['author']", "Paul").jsonString();
        System.out.println(newJson);
    }




}
