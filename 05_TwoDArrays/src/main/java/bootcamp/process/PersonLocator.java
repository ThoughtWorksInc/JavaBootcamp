package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(Person[][] people) {
        this.people = people;
    }

    public Optional<Location> find(final Person person) {
        Optional<Location> location = Optional.empty();

        for(int i = 0; i < people.length; i++){
            for(int j = 0; j < people[0].length; j++){
                if(people[i][j].equals(person)){
                    location = Optional.of(new Location(i, j));
                    break;
                }
            }
        }

//        int i = 0;
//        int j = 0;
//        while(!location.isPresent()){
//            while(i < people.length){
//                while(j < people[0].length){
//                    if(people[i][j].equals(person)){
//                        location = Optional.of(new Location(i, j));
//                    }
//                    j++;
//                }
//                i++;
//                j = 0;
//            }
//        }

        return location;
    }
}
