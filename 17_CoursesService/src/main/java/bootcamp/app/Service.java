package bootcamp.app;


import bootcamp.persistencemock.Store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("bootcamp.controller")
@SpringBootApplication
public class Service {

    @Bean
    public static Store getStore() {
        return new Store();
    }

    public static void main(final String[] args) {
        SpringApplication.run(Service.class, args);
    }
}
