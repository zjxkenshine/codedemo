package com.kenshine.saturn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 官方示例项目
 * @author kenshine
 */
@Service
public class DemoService {

	private static final Logger log = LoggerFactory.getLogger(DemoService.class);

	public void doing() {
		log.info("DemoService is doing...");
	}

}
