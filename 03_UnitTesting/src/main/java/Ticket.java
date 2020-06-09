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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return this.title == ticket.title && this.seat == ticket.seat;
    }
}
