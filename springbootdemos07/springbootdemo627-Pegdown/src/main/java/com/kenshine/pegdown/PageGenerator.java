package com.kenshine.pegdown;

import org.pegdown.PegDownProcessor;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * PegDown实现markdown转html
 * @author kenshine
 */
public class PageGenerator {
	public void generateHtml(File mdFile) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(mdFile), StandardCharsets.UTF_8));
        String line = null;
        StringBuilder mdContent = new StringBuilder();
        while ((line = br.readLine()) != null) {
            mdContent.append(line).append("\r\n");
        }
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        String htmlContent = pdp.markdownToHtml(mdContent.toString());
        System.out.println(htmlContent);
	}

	public static void main(String[] args) throws IOException {
		PageGenerator pageGenerator = new PageGenerator();
		pageGenerator.generateHtml(new File("springbootdemo627-Pegdown\\springbootdemo627.md"));
	}
	
}