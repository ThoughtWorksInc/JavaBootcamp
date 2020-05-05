package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "bootcamp.process")
public class ElementFactory {

    @Bean
    ProcessingElement adder() {
        return (x, y) -> x.add(y);
    }

    @Bean
    ProcessingElement subtractor() {
        return (x, y) -> x.subtract(y);
    }

    @Bean
    ProcessingElement multiplier() {
        return (x, y) -> x.multiply(y);
    }

    @Bean
    ProcessingElement divider() {
        return (x, y) -> x.divide(y);
    }
}
