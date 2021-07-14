package bootcamp.App;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.AddressDirectory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String [] args) {


        List<PersonAddressPair> list = new ArrayList<>();
        list.add(new PersonAddressPair(new Person("Anne", "Scott"), new Address("first line1","second line 1", "ABC1", "city1" )));
        list.add(new PersonAddressPair(new Person("Anne2", "Scott2"), new Address("first line1","second line 1", "ABC1", "city1" )));
        list.add(new PersonAddressPair(new Person("Anne3", "Scott3"), new Address("first line1","second line 1", "ABC1", "city1" )));

        list.add(new PersonAddressPair(new Person("Ryan", "Thomas"), new Address("first line2","second line 2", "ABC2", "city2" )));
        list.add(new PersonAddressPair(new Person("Michael", "Wills"), new Address("first line3","second line 3", "ABC3", "city3" )));
        list.add(new PersonAddressPair(new Person("Lorraine", "Baker"), new Address("first line4","second line 4", "ABC4", "city4" )));
        AddressDirectory directory = new AddressDirectory(list);


    }

}
