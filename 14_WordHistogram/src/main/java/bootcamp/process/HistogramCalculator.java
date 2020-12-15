package bootcamp.process;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word, Collections.frequency(words, word));
        }
        return map;
    }
}
