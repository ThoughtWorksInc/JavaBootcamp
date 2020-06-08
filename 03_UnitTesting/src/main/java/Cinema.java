public class Cinema {

    public boolean canBuyTicket(Movie movie, Customer customer){
        return customer.getAge() >= movie.getAgeRestriction();
    }

    public Ticket orderTicket(Movie movie, Customer customer, int seat) throws IllegalTicketPurchaseException {

        boolean isLegalAge = canBuyTicket(movie, customer);

        if (!isLegalAge) { throw  new IllegalTicketPurchaseException("Customer is underaged. Cannot purchase tickets"); }
        return new Ticket(movie.getTitle(), seat);
    }
}
