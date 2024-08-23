package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={"controller","services"})
@ComponentScan(basePackages = "controller")
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("hiii JPA CONFIG 1");
    }




}
