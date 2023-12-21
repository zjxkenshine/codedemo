package com.kenshine.jasper.util;

import cn.hutool.core.io.resource.ClassPathResource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

/**
 * @author by kenshine
 * @Classname JasperReportsUtil
 * @Description jasper报表工具
 * @Date 2023-12-21 14:45
 * @modified By：
 * @version: 1.0$
 */
public class JasperReportsUtil {
    /**
     * 使用 JasperReports 生成报表文件
     * @param templatePath 模板文件路径及名称
     * @param fileName 生成的文件名称
     * @param fileType 生成的文件类型,例如: pdf、html、xls 等
     * @param parameters 传递到 jrxml 模板文件中的数据参数
     * @return 返回生成的报表文件路径
     */
    public static String generateReport(String templatePath, String fileName, String fileType, Map<String, Object> parameters) throws Exception {
        // 1、获取 jasper 模板文件【采用流的方式读取】
        ClassPathResource resource = new ClassPathResource(templatePath);
        InputStream in = resource.getStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(in);
        // 2、将 parameters 数据参数填充到模板文件中
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        // 3、按照指定的 fileType 文件类型导出报表文件
        if (fileType == null || "".equals(fileType.trim())) {
            fileType = "pdf";
        }
        if (Objects.equals("pdf", fileType)) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName + ".pdf");
        // 导出 xls 表格
        } else if (Objects.equals("xls", fileType)) {
            JRXlsExporter exporter = new JRXlsExporter();
            // 设置导出的输入源
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            // 设置导出的输出源
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName + ".xls"));
            // 配置信息
            SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
            // 每一页一个sheet表格
            configuration.setOnePagePerSheet(true);
            // 设置配置对象
            exporter.setConfiguration(configuration);
            // 执行导出
            exporter.exportReport();
        // 导出 xlsx 表格
        } else if (Objects.equals("xlsx", fileType)) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            // 设置导出的输入源
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            // 设置导出的输出源
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName + ".xlsx"));
            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
            // 每一页一个sheet表格
            configuration.setOnePagePerSheet(true);
            exporter.setConfiguration(configuration);
            // 执行导出
            exporter.exportReport();
        } else if (Objects.equals("html", fileType)) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, fileName + ".html");
        }
        return "success";
    }
}
