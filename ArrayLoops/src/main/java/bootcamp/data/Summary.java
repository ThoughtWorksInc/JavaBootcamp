package bootcamp.data;

public class Summary {
    private final double _min;
    private final double _max;
    private final double _sum;
    private final double _count;
    private final double _average;

    public Summary(double min, double max, double sum, double count, double average) {
        _min = min;
        _max = max;
        _sum = sum;
        _count = count;
        _average = average;
    }

    public double getMin() {
        return _min;
    }

    public double getMax() {
        return _max;
    }

    public double getSum() {
        return _sum;
    }

    public double getCount() {
        return _count;
    }

    public double getAverage() {
        return _average;
    }
}
