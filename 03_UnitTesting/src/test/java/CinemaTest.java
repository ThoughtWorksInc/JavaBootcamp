import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaTest {
    @Test
    public void shouldBeAbleToBuyCinemaTicketWhenOlderThanRestriction() {
        //given
        int age = 19;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Frozen 2", 12);
        Cinema cinema = new Cinema();
        //when
        boolean canGetTicket = cinema.canBuyTicket(movie, customer);
        //then
        assertTrue(canGetTicket);
    }

    @Test
    public void shouldNotBeAbleToBuyCinemaTicketWhenYoungerThanRestriction() {
        //given
        int age = 11;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Frozen 2", 12);
        Cinema cinema = new Cinema();
        //when
        boolean canGetTicket = cinema.canBuyTicket(movie, customer);
        //then
        assertFalse(canGetTicket);
    }

    @Test (expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryOrderTicketAndYoungerThanAgeRestriction() {

        //arrange
        int age = 11;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Frozen 2", 12);

        // act
        Cinema sut = new Cinema();
        String message = "";

        try {
            Ticket result = sut.orderTicket(movie, customer, 15);
        } catch (Exception e){
            message = e.getMessage();
            throw e;
        }

        assertEquals("too young", message);
    }

    @Test
    public void shouldGetTicketForTheRightSeatAndMovie() {
        //given
        int age = 19;
        String title = "Frozen 2";
        int seat = 42;
        Customer customer = new Customer(age);
        Movie movie = new Movie(title, 12);
        Cinema cinema = new Cinema();
        //when
        Ticket ticket = cinema.orderTicket(movie, customer, 42);
        //then
        assertEquals(new Ticket(title, seat), ticket);
    }
}
