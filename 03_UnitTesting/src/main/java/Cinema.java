public class Cinema {
    public boolean canBuyTicket(Movie movie, Customer customer){
        if (customer.getAge() < movie.getAgeRestriction()) return false;
        return true;
    }

    public Ticket orderTicket(Movie movie, Customer customer, int seat) throws Exception {
        if (!canBuyTicket(movie, customer)) throw new Exception("Not age appropriate!");
        return new Ticket(movie.getTitle(), seat);
    }
}
