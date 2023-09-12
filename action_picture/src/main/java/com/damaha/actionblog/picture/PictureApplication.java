package com.damaha.actionblog.picture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@EnableFeignClients("com.damaha.actionblog.commons.feign")
@ComponentScan(basePackages = {
        "com.damaha.actionblog.commons.config.feign",
        "com.damaha.actionblog.commons.handler",
        "com.damaha.actionblog.commons.config.redis",
        "com.damaha.actionblog.utils",
        "com.damaha.actionblog.picture"})
public class PictureApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureApplication.class, args);
    }
}
