
package com.abnig.rest.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.abnig.model.conf.BeanConfig;
import com.abnig.rest.config.Config;

@SpringBootApplication(scanBasePackages = {"com.abnig.rest"})
@Import(value = {Config.class,  BeanConfig.class})
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}