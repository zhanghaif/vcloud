package cn.com.vcloud.admin;

import static cn.com.vcloud.admin.core.common.ProjectConstant.MAPPER_PACKAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = MAPPER_PACKAGE)
@ComponentScan("cn.com.vcloud.core,cn.com.vcloud.admin")
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
