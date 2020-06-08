package bootcamp.data;

import java.util.OptionalDouble;

public class Processor {
    private final double[] array;

    public Processor(double[] array) {
        this.array = array;
    }

    public Summary process() {
        Summary summary = new Summary(array);
        return summary;
    }

    public OptionalDouble getValue(int index) {
        if (index >= array.length || index < 0) {
            return OptionalDouble.empty();
        } else {
            return OptionalDouble.of(array[index]);
        }
    }

}
