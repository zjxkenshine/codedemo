package com.kenshine.lucene.web;

import com.kenshine.lucene.config.MyIKAnalyzer;
import com.kenshine.lucene.domain.Content;
import com.kenshine.lucene.mapper.ContentMapper;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 11:22
 * @description：测试2
 * @modified By：
 * @version: $
 */
@Controller
public class Test2Controller {

    @Autowired
    private ContentMapper contentMapper;

    private final String PATH = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo38-Lucene\\src\\main\\resources\\lucene";
    private final String PATH1 = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo38-Lucene\\src\\main\\resources\\lucene\\index";
    private final String PATH2 = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo38-Lucene\\src\\main\\resources\\lucene\\index2";

    private final String[] STR={"title","descs"};

    /**
     * 创建索引2
     * @return
     */
    @RequestMapping("/createIndex1")
    @ResponseBody
    public String createIndex(){
        List<Content> list1 = contentMapper.findAll();
        // 创建文档的集合
        Collection<Document> docs = new ArrayList<>();
        for(int i=0;i<list1.size();i++) {
            // 创建文档对象
            Document document = new Document();
            //StringField会创建索引，但是不会被分词，TextField，即创建索引又会被分词。
            document.add(new StringField("id",list1.get(i).getId().toString() , Field.Store.YES));
            //我把需要检索的内容都存一个字段里面了，回头检索的时候方便使用
            document.add(new TextField("title", list1.get(i).getTitle(), Field.Store.YES));
            document.add(new TextField("price", list1.get(i).getPrice(), Field.Store.YES));
            document.add(new TextField("descs", list1.get(i).getDescs(), Field.Store.YES));
            docs.add(document);
        }
        try {
            //先删除原来的
            File f = new File(PATH1);
            if(f.exists()){
                f.delete();
            }
            // 索引目录类,指定索引在硬盘中的位置，我的设置为D盘的indexDir文件夹
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("d:\\indexDir\\index1"));
            // 引入IK分词器
            Analyzer analyzer = new MyIKAnalyzer();
            // 索引写出工具的配置对象，这个地方就是最上面报错的问题解决方案
            IndexWriterConfig conf = new IndexWriterConfig(analyzer);
            // 设置打开方式：OpenMode.APPEND 会在索引库的基础上追加新索引。OpenMode.CREATE会先清空原来数据，再提交新的索引
            conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            // 创建索引的写出工具类。参数：索引的目录和配置信息
            IndexWriter indexWriter = new IndexWriter(directory, conf);
            // 把文档集合交给IndexWriter
            indexWriter.addDocuments(docs);
            // 提交
            indexWriter.commit();
            // 关闭
            indexWriter.close();
        } catch (Exception e) {
            return "创建失败";
        }
        return "创建成功";
    }

    @RequestMapping("/createIndex2")
    @ResponseBody
    public String createIndex1(){
        List<Content> list1 = contentMapper.findAll();
        // 创建文档的集合
        Collection<Document> docs = new ArrayList<>();
        for(int i=0;i<list1.size();i++) {
            // 创建文档对象
            Document document = new Document();
            //StringField会创建索引，但是不会被分词，TextField，即创建索引又会被分词。
            document.add(new StringField("id",list1.get(i).getId().toString() , Field.Store.YES));
            //我把需要检索的内容都存一个字段里面了，回头检索的时候方便使用
            document.add(new TextField("title", list1.get(i).getTitle()+"1", Field.Store.YES));
            document.add(new TextField("price", list1.get(i).getPrice(), Field.Store.YES));
            document.add(new TextField("descs", list1.get(i).getDescs(), Field.Store.YES));
            docs.add(document);
        }
        try {
            //先删除原来的
            File f = new File(PATH2);
            if(f.exists()){
                f.delete();
            }
            // 索引目录类,指定索引在硬盘中的位置，我的设置为D盘的indexDir文件夹
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("d:\\indexDir\\index2"));
            // 引入IK分词器
            Analyzer analyzer = new MyIKAnalyzer();
            // 索引写出工具的配置对象，这个地方就是最上面报错的问题解决方案
            IndexWriterConfig conf = new IndexWriterConfig(analyzer);
            // 设置打开方式：OpenMode.APPEND 会在索引库的基础上追加新索引。OpenMode.CREATE会先清空原来数据，再提交新的索引
            conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            // 创建索引的写出工具类。参数：索引的目录和配置信息
            IndexWriter indexWriter = new IndexWriter(directory, conf);
            // 把文档集合交给IndexWriter
            indexWriter.addDocuments(docs);
            // 提交
            indexWriter.commit();
            // 关闭
            indexWriter.close();
        } catch (Exception e) {
            return "创建失败";
        }
        return "创建成功";
    }

    /**
     * 多索引查询
     * @param text
     * @param request
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws InvalidTokenOffsetsException
     */
    @RequestMapping("/searchText4")
    public String searchText4(String text, HttpServletRequest request) throws IOException, ParseException, InvalidTokenOffsetsException {
        int page=1;
        int pageSize=100;
        IndexSearcher searcher = getMoreSearch(PATH);
        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        MultiFieldQueryParser parser = new MultiFieldQueryParser(STR, new MyIKAnalyzer());
        // 创建查询对象
        Query query = parser.parse(text);

        TopDocs topDocs = searchByPage(page,pageSize,searcher,query);
        // 获取总条数
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");

        //高亮显示
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
        Fragmenter fragmenter = new SimpleFragmenter(100);   //高亮后的段落范围在100字内
        highlighter.setTextFragmenter(fragmenter);

        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<Content> list = new ArrayList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            //Document doc = reader.document(docID);
            Document doc = searcher.doc(docID);//多索引找文档要用searcher找了，reader容易报错
            Optional<Content> contentOptional =contentMapper.findById(Integer.parseInt(doc.get("id")));
            if(contentOptional.isPresent()) {
                Content content = contentOptional.get();

                //处理高亮字段显示
                String title = highlighter.getBestFragment(new MyIKAnalyzer(), "title", doc.get("title"));
                if (title == null) {
                    title = content.getTitle();
                }
                String descs = highlighter.getBestFragment(new MyIKAnalyzer(), "descs", doc.get("descs"));
                if (descs == null) {
                    descs = content.getDescs();
                }
                content.setDescs(descs);
                content.setTitle(title);
                list.add(content);
            }
        }
        System.err.println("list的长度："+list.size());
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("list",list);
        return "index";
    }

    private IndexSearcher getMoreSearch(String string) {
        MultiReader reader = null;
        //设置
        try {
            File[] files = new File(string).listFiles();

            IndexReader[] readers = new IndexReader[files.length];
            for (int i = 0 ; i < files.length ; i ++) {
                readers[i] = DirectoryReader.open(FSDirectory.open(Paths.get(files[i].getPath(), new String[0])));
            }
            reader = new MultiReader(readers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new IndexSearcher(reader);
        //如果索引文件过多，可以这样加快效率
        /**
         ExecutorService service = Executors.newCachedThreadPool();
         return new IndexSearcher(reader,service);
         */
    }

    private TopDocs searchByPage(int page,int perPage, IndexSearcher searcher, Query query) throws IOException {
        TopDocs result = null;
        if(query == null){
            System.out.println(" Query is null return null ");
            return null;
        }
        ScoreDoc before = null;
        if(page != 1){
            TopDocs docsBefore = searcher.search(query, (page-1)*perPage);
            ScoreDoc[] scoreDocs = docsBefore.scoreDocs;
            if(scoreDocs.length > 0){
                before = scoreDocs[scoreDocs.length - 1];
            }
        }
        result = searcher.searchAfter(before, query, perPage);
        return result;
    }

    /**
     * 条件查询
     * http://localhost:8080/search?text=vue
     */
    @GetMapping("/search")
    public ModelAndView searchText2(String text,HttpServletRequest request) throws IOException,ParseException, InvalidTokenOffsetsException{
        //单索引查询
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH1));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);

        //多条件查询构造
        BooleanQuery.Builder builder = new BooleanQuery.Builder();

        // 条件一
        MultiFieldQueryParser  parser = new MultiFieldQueryParser(STR, new MyIKAnalyzer());
        // 创建查询对象
        Query query = parser.parse(text);
        builder.add(query, BooleanClause.Occur.MUST);
        //条件二 TermQuery 精确查询
        Query termQuery = new TermQuery(new Term("price", "20"));
        builder.add(termQuery, BooleanClause.Occur.MUST);

        // 获取前十条记录
        TopDocs topDocs = searcher.search(builder.build(), 100);
        // 获取总条数
        System.err.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        //高亮显示
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
        Fragmenter fragmenter = new SimpleFragmenter(100);   //高亮后的段落范围在100字内
        highlighter.setTextFragmenter(fragmenter);

        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<Content> list = new ArrayList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            Document doc = reader.document(docID);
            Optional<Content> contentOptional =contentMapper.findById(Integer.parseInt(doc.get("id")));
            if(contentOptional.isPresent()) {
                Content content = contentOptional.get();
                //处理高亮字段显示
                String title = highlighter.getBestFragment(new MyIKAnalyzer(), "title", doc.get("title"));
                if (title == null) {
                    title = content.getTitle();
                }
                String descs = highlighter.getBestFragment(new MyIKAnalyzer(), "descs", doc.get("descs"));
                if (descs == null) {
                    descs = content.getDescs();
                }
                content.setDescs(descs);
                content.setTitle(title);
                list.add(content);
            }
        }
        request.setAttribute("list",list);
        return new ModelAndView("index");
    }



}
