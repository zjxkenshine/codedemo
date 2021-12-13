package com.kenshine.poiword.web;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 9:23
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class PoiWordController {

    /**
     * 按段落解析一个word文档
     * @param file
     * @return
     * @throws Exception
     */
    @ApiOperation(value="解析word文档", notes="按段落解析word文档")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map uploadFile(@RequestParam(value = "file", required = true) MultipartFile file){
        String textFileName=file.getOriginalFilename();
        //创建一个map对象存放word中的内容
        Map wordMap = new LinkedHashMap();
        try {
            //判断文件格式
            if(textFileName.endsWith(".doc")){
                InputStream fis = file.getInputStream();
                //使用HWPF组件中WordExtractor类从Word文档中提取文本或段落
                WordExtractor wordExtractor = new WordExtractor(fis);
                int i=1;
                //获取段落内容
                for(String words : wordExtractor.getParagraphText()){
                    System.out.println(words);
                    wordMap.put("DOC文档，第（"+i+"）段内容",words);
                    i++;
                }
                fis.close();
            }
            //docx文件
            if(textFileName.endsWith(".docx")){
                //创建一个临时文件
                File uFile = new File("tempFile.docx");
                if(!uFile.exists()){
                    uFile.createNewFile();
                }
                //复制文件内容
                FileCopyUtils.copy(file.getBytes(), uFile);
                //包含所有POI OOXML文档类的通用功能，打开一个文件包。
                OPCPackage opcPackage = POIXMLDocument.openPackage("tempFile.docx");
                //使用XWPF组件XWPFDocument类获取文档内容
                XWPFDocument document = new XWPFDocument(opcPackage);
                List<XWPFParagraph> paras = document.getParagraphs();
                int i=1;
                for(XWPFParagraph paragraph : paras){
                    String words = paragraph.getText();
                    System.out.println(words);
                    wordMap.put("DOCX文档，第（"+i+"）段内容",words);
                    i++;
                }
                uFile.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(wordMap);
        return wordMap;
    }

    /**
     * poi导出word
     */
    @ApiOperation(value="导出word文档", notes="导出word文档")
    @GetMapping("/exportDoc")
    public String exportDoc(){
        //创建Word对象
        XWPFDocument xwpfDocument = new XWPFDocument();
        //创建一个段落对象
        XWPFParagraph titleParagraph = xwpfDocument.createParagraph ();
        //创建文本对象
        XWPFRun titleParagraphRun = titleParagraph.createRun ();
        titleParagraphRun.setBold (true);
        titleParagraphRun.setText ("这是一个POI操作Word的测试");
        titleParagraphRun.setColor ("FF0000");
        titleParagraphRun.setText ("红色的字？");
        String fileName = "POI操作Word.doc";
        try {
            OutputStream outputStream = new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo175-Poi-Word\\src\\main\\resources\\export\\" +fileName);
            //执行写出到本地
            xwpfDocument.write (outputStream);
            xwpfDocument.close ();
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return "success";
    }


}
