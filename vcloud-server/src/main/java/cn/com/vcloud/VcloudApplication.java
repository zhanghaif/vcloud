package cn.com.vcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(VcloudApplication.class, args);
	}

}
