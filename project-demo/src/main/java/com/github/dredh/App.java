package com.github.dredh;

import com.dredh.ModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 */
//@MapperScan(basePackages = "com.gihub.dred.repository")
@SpringBootApplication
@ComponentScan
@Import(ModuleConfig.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
