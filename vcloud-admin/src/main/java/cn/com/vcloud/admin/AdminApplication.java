package cn.com.vcloud.admin;

import static cn.com.vcloud.core.common.ProjectConstant.ADMIN_MAPPER_PACKAGE;
import static cn.com.vcloud.core.common.ProjectConstant.ADMIN_BASE_PACKAGE;
import static cn.com.vcloud.core.common.ProjectConstant.CORE_PACKAGE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = ADMIN_MAPPER_PACKAGE)
@ComponentScan(CORE_PACKAGE)
@ComponentScan(ADMIN_BASE_PACKAGE)
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
