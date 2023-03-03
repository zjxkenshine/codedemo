package com.kenshine.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author by kenshine
 * @Classname FinebiApplication
 * @Description TODO
 * @Date 2023/3/2 15:18
 * @modified By?
 * @version: 1.0$
 */

@SpringBootApplication
public class FineReportApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FineReportApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FineReportApplication.class);
    }

}
