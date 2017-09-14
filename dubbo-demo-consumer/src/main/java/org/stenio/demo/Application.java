package org.stenio.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.stenio.demo.api.TestService;

import java.io.IOException;

/**
 * Created by stenio on 2017/9/11.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        TestService testService = run.getBean("testService", TestService.class);
        String test = testService.test();
        System.out.println(test);
        System.in.read();
    }

}
