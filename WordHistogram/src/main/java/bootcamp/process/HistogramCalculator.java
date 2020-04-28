package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        TreeMap<String, Integer> histogramCalc = new TreeMap<>();
        words.forEach(word -> {
            if (histogramCalc.containsKey(word)) {
                histogramCalc.put(word, histogramCalc.get(word) + 1);
            } else {
                histogramCalc.put(word, 1);
            }
        });

        return histogramCalc;
    }
}
