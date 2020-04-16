package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ComponentScan
public class ElementFactory {
    @Bean
    ProcessingElement adder() {
        return BigDecimal::add;
    }

    @Bean
    ProcessingElement subtractor() {
        return BigDecimal::subtract;
    }

    @Bean
    ProcessingElement multiplier() {
        return BigDecimal::multiply;
    }

    @Bean
    ProcessingElement divider() {
        return BigDecimal::divide;
    }
}
