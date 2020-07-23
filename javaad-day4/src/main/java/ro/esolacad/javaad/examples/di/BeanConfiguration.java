package ro.esolacad.javaad.examples.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ro.esolacad.javaad.examples.car.*;

@Configuration
public class BeanConfiguration {

//    @Bean
//    public Car createCarBean(Motor motor, AC ac) {
//        Car car = new Car(motor);
//
//        car.setAC(ac);
//
//        return car;
//    }
//
//    @Bean
//    public Motor createNormalMotor() {
//        return new NormalMotor();
//    }
//
//    @Bean
//    public AC createNormalAC() {
//        return new NormalAC();
//    }

    @Bean("urlForDatabase")
    public String databaseUrl() {
        return "database_url";
    }
}
