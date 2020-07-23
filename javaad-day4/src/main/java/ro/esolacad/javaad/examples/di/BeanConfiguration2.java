package ro.esolacad.javaad.examples.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration2 {

    @Bean
    public String applicationName() {
        return "spring-shop";
    }
}
