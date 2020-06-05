package bootcamp.app;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.db.JdbcFactory;
import bootcamp.reader.AddressDirectory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] main) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcFactory.class);
        AddressDirectory directory = ctx.getBean(AddressDirectory.class);
        Address address = new Address("25", "The Ridge", "Bedford", "MK17 3XS");
        directory.getResidents(address);
        //TODO print out the residents at the given address.
        //TODO write code to test getAddress method of directory.
        //TODO make queries for both methods to test edge conditions, e.g., address does not exist, person does not exist, etc.
    }
}
