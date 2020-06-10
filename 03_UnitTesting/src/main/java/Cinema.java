
public class Cinema {

    public boolean canBuyTicket(Movie movie, Customer customer){

        return customer.getAge() >= movie.getAgeRestriction();
    }

    public Ticket orderTicket(Movie movie, Customer customer, int seat) {

        if (!canBuyTicket(movie, customer)) {
            throw new RuntimeException("too young");
        } else {
            return new Ticket("Frozen 2", seat);
        }
    }
}
