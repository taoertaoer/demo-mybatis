package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.xdd.interceptor.Interceptor;

@RestController
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@MapperScan(basePackages= {"com.xdd.dao"})
//WebMvcConfigurerAdapter
public class DemoMybatisApplication  extends SpringBootServletInitializer{

	@RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
	
	/**
     * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoMybatisApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMybatisApplication.class, args);
	}

	/**
     * 配置拦截器
     * @author lance
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
	}
}
