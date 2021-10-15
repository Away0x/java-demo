package ltd.newbee.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBootApplication
// - 标明这是一个 Spring boot app, 其包含了三个注解
//   - SpringBootConfiguration: Spring Boot 配置
//   - EnableAutoConfiguration: 启用自动配置
//   - ComponentScan: 组件自动扫描
@MapperScan("ltd.newbee.mall.dao")
@SpringBootApplication
public class NewbeeMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewbeeMallApplication.class, args);
	}

}
