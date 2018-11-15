package com.notasprogramacion.springboot.jpa.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	@Autowired
	private ICourseJpaRepository courseJpaRepository;
	
	public void sayHello() {
		LOG.info("HELLO FROM ExampleComponent");
	}
}
