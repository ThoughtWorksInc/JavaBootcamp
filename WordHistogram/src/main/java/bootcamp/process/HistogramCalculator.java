package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        HashMap<String, Integer> histogramCalc = new HashMap<>();
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
