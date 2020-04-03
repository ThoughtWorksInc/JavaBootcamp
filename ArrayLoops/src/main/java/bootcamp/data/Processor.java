package bootcamp.data;

import java.lang.reflect.Array;
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
        if (index >= array.length) {
            return OptionalDouble.empty();
        } else {
            return OptionalDouble.of(array[index]);
        }
    }

}
