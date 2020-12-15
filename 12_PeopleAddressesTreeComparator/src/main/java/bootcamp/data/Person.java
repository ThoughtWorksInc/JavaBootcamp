package bootcamp.data;

public class Person {
    private final String firstName; //FIXME
    private final String secondName; //FIXME

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public static int compare(Person o1, Person o2) {
        String name1 = String.format("%s%s", o1.getFirstName(), o1.getSecondName());
        String name2 = String.format("%s%s", o2.getFirstName(), o2.getSecondName());
        return name1.compareTo(name2);
    }

}
