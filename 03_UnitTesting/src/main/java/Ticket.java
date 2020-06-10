public class Ticket {
    private final String title;
    private final int seat;

    public Ticket(String title, int seat) {
        this.title = title;
        this.seat = seat;
    }

    public String getTitle() {
        return title;
    }

    public int getSeat() {
        return seat;
    }

    public boolean equals(Object o){

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;
        return ticket.seat == this.seat && ticket.title.equals(title);
    }
}
