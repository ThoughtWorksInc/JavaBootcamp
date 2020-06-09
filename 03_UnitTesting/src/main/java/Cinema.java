public class Cinema {
    public boolean canBuyTicket(Movie movie, Customer customer) {
        return customer.getAge() >= movie.getAgeRestriction();
    }

    public Ticket orderTicket(Movie movie, Customer customer, int seat) {
        if (this.canBuyTicket(movie, customer)) {
            return new Ticket(movie.getTitle(), seat);
        } else {
            throw new RuntimeException();
        }

    }
}
