package bootcamp.persistencemock;

public class NotFoundException extends Exception {

    public NotFoundException(final int id, final String concept) {
        super(String.format("%d ID does not exist for %s", id, concept));
    }
}
