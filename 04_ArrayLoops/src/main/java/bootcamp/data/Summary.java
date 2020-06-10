package bootcamp.data;

public class Summary {
    private final double min;
    private final double max;
    private final double sum;
    private final double count;
    private final double average;

    public Summary(double min, double max, double sum, double count, double average){
       this.min = min;
       this.max = max;
       this.sum = sum;
       this.count = count;
       this.average = average;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getSum() {
        return sum;
    }

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.min, min) == 0 &&
                Double.compare(summary.max, max) == 0 &&
                Double.compare(summary.sum, sum) == 0 &&
                Double.compare(summary.count, count) == 0 &&
                Double.compare(summary.average, average) == 0;
    }
}
