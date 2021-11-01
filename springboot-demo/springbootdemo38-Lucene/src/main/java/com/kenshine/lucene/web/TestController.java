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
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 9:26
 * @description：Lucene测试类
 * @modified By：
 * @version: $
 */
@Controller
public class TestController {

    @Autowired
    private ContentMapper contentMapper;

    private final String PATH = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo38-Lucene\\src\\main\\resources\\lucene\\index";

    private final String[] STR={"title","descs"};

    /**
     * 创建索引，文档
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/createIndex")
    public String createIndex() throws IOException {
        List<Content> list1 = contentMapper.findAll();
        // 创建文档的集合
        Collection<Document> docs = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            //contentMapper.insertSelective(list1.get(i));
            // 创建文档对象
            Document document1 = new Document();
            //StringField会创建索引，但是不会被分词，TextField，即创建索引又会被分词。
            document1.add(new StringField("id", (i+1)+"", Field.Store.YES));

            document1.add(new TextField("title", list1.get(i).getTitle(), Field.Store.YES));
            document1.add(new TextField("price", list1.get(i).getPrice(), Field.Store.YES));
            document1.add(new TextField("descs", list1.get(i).getDescs(), Field.Store.YES));
            docs.add(document1);
        }


        // 索引目录类,指定索引在硬盘中的位置，我的设置为D盘的indexDir文件夹
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
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

        return"success";
    }

    /**
     * 查询数据
     * @param text
     * @param request
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @RequestMapping("/searchText")
    public String searchText(String text, HttpServletRequest request) throws ParseException, IOException {
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);
        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        QueryParser parser = new QueryParser("descs", new MyIKAnalyzer());
        // 创建查询对象
        Query query = parser.parse(text);
        // 获取前十条记录
        TopDocs topDocs = searcher.search(query, 10);
        // 获取总条数
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<Content> list = new ArrayList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            Document doc = reader.document(docID);
            //会报错
            //Content content = contentMapper.getOne(Integer.parseInt(doc.get("id")));
            Optional<Content> content =contentMapper.findById(Integer.parseInt(doc.get("id")));
            content.ifPresent(list::add);
        }
        request.setAttribute("list", list);
        return "index";
    }

    /**
     * 多字段查詢
     * @param text
     * @param request
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @RequestMapping("/searchText1")
    public String searchText1(String text,HttpServletRequest request) throws IOException,ParseException{
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);
        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        MultiFieldQueryParser parser = new MultiFieldQueryParser(new String[]{"title","descs"}, new MyIKAnalyzer());
        // 创建查询对象
        Query query = parser.parse(text);
        // 获取前十条记录
        TopDocs topDocs = searcher.search(query, 100);
        // 获取总条数
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<Content> list = new ArrayList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            Document doc = reader.document(docID);
            Optional<Content> content =contentMapper.findById(Integer.parseInt(doc.get("id")));
            content.ifPresent(list::add);
        }
        request.setAttribute("list", list);
        return "index";
    }

    /**
     * 高亮显示
     * @param text
     * @param request
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws InvalidTokenOffsetsException
     */
    @RequestMapping("/searchText2")
    public String searchText2(String text,HttpServletRequest request) throws IOException,ParseException, InvalidTokenOffsetsException {
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);
        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        MultiFieldQueryParser  parser = new MultiFieldQueryParser(STR, new MyIKAnalyzer());
        // 创建查询对象
        Query query = parser.parse(text);
        // 获取前十条记录
        TopDocs topDocs = searcher.search(query, 100);
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
            Document doc = reader.document(docID);
            Optional<Content> contentOptional =contentMapper.findById(Integer.parseInt(doc.get("id")));
            if(contentOptional.isPresent()){
                Content content = contentOptional.get();
                //处理高亮字段显示
                String title = highlighter.getBestFragment(new MyIKAnalyzer(), "title",doc.get("title"));
                if(title==null){
                    title=content.getTitle();
                }
                String descs = highlighter.getBestFragment(new MyIKAnalyzer(), "descs",doc.get("descs"));
                if(descs==null){
                    descs=content.getDescs();
                }
                content.setDescs(descs);
                content.setTitle(title);
                list.add(content);
            }

        }
        request.setAttribute("list",list);
        return "index";
    }


    /**
     * 更新索引
     * //更新指定id的数据
     */
    @RequestMapping("/updateIndex")
    @ResponseBody
    public String update(String age) throws IOException{
        // 创建目录对象
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
        // 创建配置对象
        IndexWriterConfig conf = new IndexWriterConfig(new MyIKAnalyzer());
        // 创建索引写出工具
        IndexWriter writer = new IndexWriter(directory, conf);
        // 创建新的文档数据
        Document doc = new Document();
        doc.add(new StringField("id","34", Field.Store.YES));
        Optional<Content> contentOptional =contentMapper.findById(34);
        if(contentOptional.isPresent()){
            Content content = contentOptional.get();
            content.setTitle("宫本武藏超级兵");
            //saveAndFlush 包含保存数据的id
            contentMapper.save(content);

            doc.add(new TextField("title", content.getTitle(), Field.Store.YES));
            doc.add(new TextField("price", content.getPrice(), Field.Store.YES));
            doc.add(new TextField("descs", content.getDescs(), Field.Store.YES));
            writer.updateDocument(new Term("id","34"), doc);
            // 提交
            writer.commit();
        }
        // 关闭
        writer.close();
        return "success";
    }


    /**
     * 删除指定索引
     */
    @RequestMapping("/deleteIndex")
    @ResponseBody
    public String deleteIndex() throws IOException{
        // 创建目录对象
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
        // 创建配置对象
        IndexWriterConfig conf = new IndexWriterConfig(new IKAnalyzer());
        // 创建索引写出工具
        IndexWriter writer = new IndexWriter(directory, conf);
        // 根据词条进行删除
        writer.deleteDocuments(new Term("id", "34"));
        // 提交
        writer.commit();
        // 关闭
        writer.close();
        return "success";
    }

    /**
     * 分页查询
     */
    @RequestMapping("/searchText3")
    public String searchText3(String text,HttpServletRequest request) throws IOException,ParseException, InvalidTokenOffsetsException{
        int page=1;
        int pageSize=10;
        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(PATH));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);
        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        MultiFieldQueryParser  parser = new MultiFieldQueryParser(STR, new MyIKAnalyzer());
        // 创建查询对象
        Query query = parser.parse(text);
        // 获取前十条记录
        //TopDocs topDocs = searcher.search(query, 100);

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
        System.err.println("list的长度："+list.size());
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("list",list);
        return "index";
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








}
