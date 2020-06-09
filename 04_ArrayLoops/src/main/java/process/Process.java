package process;

import bootcamp.data.Summary;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Process {

    private final ArrayList<Double> arrayList;

    public Process(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    public Summary process() {

        double sum = getSum();
        double minValue = getMinValue();
        double maxValue = getMaxValue();
        double count = getCount();
        double average = getAverageValue();

        return new Summary(minValue, maxValue, sum, count, average);
    }

    public Optional<Double> getValue(int index) {
        return (index > arrayList.size() || index < 0) ? Optional.empty() : Optional.of(arrayList.get(index));
    }

    private double performCalculation(BinaryOperator<Double> operation, double defaultValue ) {
        return arrayList.isEmpty() ? defaultValue : arrayList.stream().reduce(operation).get();
    }

    private double getMinValue() {
        return performCalculation(Double::min, Double.NaN);
    }

    private double getMaxValue() {
        return performCalculation(Double::max, Double.NaN);
    }

    private double getSum() {
        return performCalculation(Double::sum, 0.0);
    }

    private int getCount() {
        return arrayList.size();
    }

    private double getAverageValue() {
        double averageValue = getSum() / arrayList.size();
        return arrayList.isEmpty() ? Double.NaN : averageValue;
    }
}
