package pl.akolata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "pl.akolata")
public class RecipesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipesServiceApplication.class, args);
    }
}
