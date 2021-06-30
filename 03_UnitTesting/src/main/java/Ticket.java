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
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Ticket ticket = (Ticket) object;
        return this.title.equals(ticket.getTitle())
                && this.seat == ticket.getSeat();
    }

}
