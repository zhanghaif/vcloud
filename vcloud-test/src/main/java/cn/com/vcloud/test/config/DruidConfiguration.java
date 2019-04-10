package cn.com.vcloud.test.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * 
 * @className: DruidConfiguration.java
 * @description: Druid
 * @author zhanghaifeng
 * @dateTime 2019年4月9日 下午2:30:52
 */
@Configuration
public class DruidConfiguration {

	/**
	 * 
	 * @Title: druidDataSource   
	 * @Description: Mybatis在不使用springboot整合的时候 也是需要配置释放方法以及初始化方法 
	 * @param: @return      
	 * @return: DataSource      
	 * @throws
	 */
	@Primary
    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource druidDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

}
