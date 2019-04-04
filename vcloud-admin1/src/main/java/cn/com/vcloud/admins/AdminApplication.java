package cn.com.vcloud.admins;

import static cn.com.vcloud.admin.core.common.ProjectConstant.MAPPER_PACKAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"cn.com.vcloud.admins","cn.com.vcloud.admin"})
@ComponentScan(basePackages = {"cn.com.vcloud.admin"})
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
