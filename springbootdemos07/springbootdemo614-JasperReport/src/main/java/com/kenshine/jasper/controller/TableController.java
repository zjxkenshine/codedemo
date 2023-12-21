package com.kenshine.jasper.controller;

import cn.hutool.core.io.resource.ClassPathResource;
import com.kenshine.jasper.model.MainEntity;
import com.kenshine.jasper.model.SubEntity;
import com.kenshine.jasper.util.JasperReportsUtil;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname TableController
 * @Description 报表
 * @Date 2023-12-21 14:42
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("/report")
public class TableController {

    /**
     * http://localhost:8080/report/table?format=pdf
     */
    @GetMapping("/table")
    public String exportFile(String format) throws Exception {
        ClassPathResource resource = new ClassPathResource("jaspers\\tableTest.jasper");
        String templatePath = resource.getPath();
        String fileName = "springbootdemo614-JasperReport\\output\\tableTest";
        /*
         创建传递到 Jasper 模板文件中的数据参数。
         注意：参数的 key 必须和 Jasper Studio 中创建的 Parameters 参数名称相同，否则匹配不上，无法填充数据。
         */
        Map<String, Object> parameters = new HashMap<>();
        // 表格数据集是 JRBeanCollectionDataSource 类型的，也就是 JavaBean 实体类类型
        List<Map<String, Object>> data = this.getData(100);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        // 这里的 tableData 字段名称就是和模板文件中表格数据集的参数名称相同
        parameters.put("tableData", dataSource);
        // 执行导出操作
        return JasperReportsUtil.generateReport(templatePath, fileName, format, parameters);
    }

    private List<Map<String, Object>> getData(int num) {
        List<Map<String, Object>> ansMap = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Map<String, Object> map = new HashMap<>();
            // 这里的 key 必须和模板文件中的 Field 字段的名称相同
            map.put("id", i+"test");
            map.put("name", "name" + i);
            map.put("age", (i + 20)+"");
            map.put("sex", i % 2 == 0 ? "男" : "女");
            ansMap.add(map);
        }
        return ansMap;
    }

    /**
     * http://localhost:8080/report/sub-report?format=pdf
     */
    @GetMapping("/sub-report")
    public String exportFile1(String format) throws Exception {
        ClassPathResource resource = new ClassPathResource("jaspers\\main_report.jasper");
        String templatePath = resource.getPath();
        String fileName = "springbootdemo614-JasperReport\\output\\main_sub";
        // 表格数据集是 JRBeanCollectionDataSource 类型的，也就是 JavaBean 实体类类型
        List<MainEntity> data = this.getData1(3);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        // 设置 parameters 参数
        Map<String, Object> parameters = new HashMap<>();
        String subReportPath = new ClassPathResource("jaspers\\sub_report.jasper").getPath();
        // 设置子报表的路径
        parameters.put("subPath", subReportPath);
        // 执行导出操作
        return JasperReportsUtil.generateReport(templatePath, fileName, format, parameters, dataSource);
    }

    private List<MainEntity> getData1(int num) {
        List<MainEntity> ansMap = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            MainEntity main = new MainEntity();
            main.setProduct("product_00" + i);
            main.setCategory("phone_00" + i);
            List<SubEntity> subData = new ArrayList<>();
            int idx = (int)(Math.random() * 10) + i;
            for (int j = 0; j < idx; j++) {
                SubEntity subEntity = new SubEntity();
                subEntity.setName("name_" + j);
                subEntity.setPrice((int)(Math.random() * 100) + "");
                subEntity.setAmount((int)(Math.random() * 100));
                subData.add(subEntity);
            }
            main.setSubData(subData);
            ansMap.add(main);
        }
        return ansMap;
    }

}
