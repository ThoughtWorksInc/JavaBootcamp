package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        Map<String, Integer> histogram = new HashMap<>();
        for (String word : words) {
            histogram.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        return histogram;
    }
}
