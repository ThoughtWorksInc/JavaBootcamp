package bootcamp.app;

import bootcamp.data.Address;
import bootcamp.db.JdbcFactory;
import bootcamp.reader.AddressDirectory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] main) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcFactory.class);
        AddressDirectory directory = ctx.getBean(AddressDirectory.class);
        Address address = new Address("25", "The Ridge", "Bedford", "MK17 3XS");

        final var residents = directory.getResidents(address);

        if (residents.value.isEmpty()) {
            System.out.println(residents.message);
        } else {
            final var dbAddress = residents.value.get().address;
            System.out.println("ADDRESS IS:");
            System.out.println(dbAddress.firstLine + " " + dbAddress.secondLine);
            System.out.println(dbAddress.city + ", " + dbAddress.postCode);

            final var people = residents.value.get().residents;
            System.out.println();
            System.out.println("RESIDENTS ARE:");
            for (int i = 0; i < people.size(); i++) {
                final var person = people.get(i);
                System.out.println(person.firstName + " " + person.secondName);
            }
        }
    }
}
