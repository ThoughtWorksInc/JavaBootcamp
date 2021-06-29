package bootcamp.data;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return  this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

   @Override
    public boolean equals(Object object){
       if (this == object) return true;
       if (object == null || this.getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return this.firstName.equals(person.getFirstName())
            && this.lastName.equals(person.getLastName());
   }
}
