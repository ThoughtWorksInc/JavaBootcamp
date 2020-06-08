import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaTest {
    @Test
    public void shouldBeAbleToBuyCinemaTicketWhenOlderThanRestriction() {
        int age = 19;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Frozen 2", 12);
        Cinema cinema = new Cinema();

        boolean canGetTicket = cinema.canBuyTicket(movie, customer);

        assertTrue(canGetTicket);
    }

    @Test
    public void shouldNotBeAbleToBuyCinemaTicketWhenYoungerThanRestriction() {
        int age = 9;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Frozen xxx", 18);
        Cinema cinema = new Cinema();

        boolean canGetTicket = cinema.canBuyTicket(movie, customer);

        assertFalse(canGetTicket);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryOrderTicketAndYoungerThanAgeRestriction() throws IllegalTicketPurchaseException {
        int age = 6;
        String title = "Frozen xxx";
        int seat = 42;
        Customer customer = new Customer(age);
        Movie movie = new Movie(title, 18);
        Cinema cinema = new Cinema();

        Ticket ticket = cinema.orderTicket(movie, customer, seat);
    }

    @Test
    public void shouldGetTicketForTheRightSeatAndMovie() throws IllegalTicketPurchaseException {

        int age = 19;
        String title = "Frozen 2";
        int seat = 42;
        Customer customer = new Customer(age);
        Movie movie = new Movie(title, 12);
        Cinema cinema = new Cinema();

        Ticket ticket = cinema.orderTicket(movie, customer, seat);

        assertEquals(new Ticket(title, seat), ticket);
    }
}
