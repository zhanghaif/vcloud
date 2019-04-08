package cn.com.vcloud.test;

import static cn.com.vcloud.test.common.ProjectConstant.MAPPER_PACKAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = MAPPER_PACKAGE)
@ComponentScan("cn.com.vcloud.core,cn.com.vcloud.test")
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
