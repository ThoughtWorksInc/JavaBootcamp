package bootcamp.data;

import java.util.OptionalDouble;

public class Processor {
    private double[] _numArray;

    public Processor(double[] numArray) {
        _numArray = numArray;
    }

    public Summary process() {
        if (_numArray.length == 0) {
            return new Summary(Double.NaN,Double.NaN,Double.NaN,Double.NaN,Double.NaN);
        }
        double max = 0;
        double min = _numArray[0];
        double sum = 0;
        double count = _numArray.length;
        double average;

        for (int i=0; i<_numArray.length; i++) {
            if (_numArray[i]>max) {
                max = _numArray[i];
            }
            if (_numArray[i]<min) {
                min = _numArray[i];
            }
            sum += _numArray[i];
        }
        average = sum / count;

        return new Summary(min, max, sum, count, average);
    }

    public OptionalDouble getValue(int index) {
        try {
            return OptionalDouble.of(_numArray[index]);
        } catch(IndexOutOfBoundsException error) {
            return OptionalDouble.empty();
        }
    }
}
