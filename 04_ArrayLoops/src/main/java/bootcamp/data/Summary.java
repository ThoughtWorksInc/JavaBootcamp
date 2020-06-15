package bootcamp.data;

public class Summary {
    private final double min;
    private final double max;
    private final double sum;
    private final double count;
    private final double average;

    public Summary(
            final double min,
            final double max,
            final double sum,
            final double count,
            final double average)
    {
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
}
