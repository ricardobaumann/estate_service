package estate_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ricardobaumann on 06/01/17.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@RestController
public class EstateServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "estate_service");
        SpringApplication.run(EstateServiceApplication.class);
    }



}
