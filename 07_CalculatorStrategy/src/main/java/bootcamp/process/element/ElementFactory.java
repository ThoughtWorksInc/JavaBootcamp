package bootcamp.process.element;

public interface ElementFactory {
    ProcessingElement create(final String operator);
}
