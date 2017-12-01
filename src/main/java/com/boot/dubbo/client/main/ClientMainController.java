package com.boot.dubbo.client.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
//扫描controller即有请求地址所在包
@ComponentScan(value = {"com.boot.dubbo.client.web"})
@ImportResource("classpath:consumer.xml")
@SpringBootApplication
public class ClientMainController extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientMainController.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ClientMainController.class);
    }

    //修改启动端口
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(18080);
    }
    
}
