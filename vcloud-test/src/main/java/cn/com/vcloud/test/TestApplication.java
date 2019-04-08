package cn.com.vcloud.test;

import static cn.com.vcloud.core.common.ProjectConstant.TEST_BASE_PACKAGE;
import static cn.com.vcloud.core.common.ProjectConstant.TEST_MAPPER_PACKAGE;
import static cn.com.vcloud.core.common.ProjectConstant.CORE_PACKAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = TEST_MAPPER_PACKAGE)
@ComponentScan(CORE_PACKAGE)
@ComponentScan(TEST_BASE_PACKAGE)
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
