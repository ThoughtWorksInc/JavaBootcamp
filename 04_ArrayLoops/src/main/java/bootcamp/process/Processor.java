package bootcamp.process;

import bootcamp.data.Summary;

public class Processor {

    private final double[] array;

    public Processor(double[] array) {
        this.array = array;
    }

    public Summary process() {

        double count = array.length;
        double sum = 0;
        double min = Double.NaN;
        double max = Double.NaN;
        double average = Double.NaN;

        if (count > 0) {

            min = array[0];
            for (double v : array) {
                if (v < min) {
                    min = v;
                }
            }

            max = array[0];
            for (double v : array) {
                if (v > max) {
                    max = v;
                }
            }

            for (double v : array) {
                sum += v;
            }

            average = sum /count;
        }

        return new Summary(min, max, sum, count, average);
    }

    public double getValue(int index) {
        if (index >= 0 && index <= this.array.length) {
            return array[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
