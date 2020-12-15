package bootcamp.app;


import bootcamp.data.*;
import bootcamp.db.JdbcFactory;
import bootcamp.reader.AddressDirectory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] main) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcFactory.class);
        AddressDirectory directory = ctx.getBean(AddressDirectory.class);
        Address address = new Address("25", "The Ridge", "Bedford", "MK17 3XS");
        Result<Residents> residentsResult = directory.getResidents(address);
        if (residentsResult.getStatus() != Status.SUCCESS ) {
            Residents residents = residentsResult.getValue().get();
            for (Person p : residents.getResidents()) {
                System.out.println(p);
            }
        }
        else {
            System.out.println("Error: " + residentsResult);
        }
    }
}