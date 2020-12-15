package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class CalculatorApp {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("bootcamp");
        BeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        Calculator calculator = beanFactory.getBean(Calculator.class);
        Params params = new Params(BigDecimal.TEN, BigDecimal.TEN, "+");
        Result result = calculator.calculate(params);
        System.out.println(result);
    }
}
