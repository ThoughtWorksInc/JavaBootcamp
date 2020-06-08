package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        return words.stream().collect(
            () -> new HashMap<>(),
            (collectedMap, word) -> {
                final Integer count = collectedMap.containsKey(word) ? collectedMap.get(word) + 1 : 1;
                collectedMap.put(word, count);
            },
            (a, b) -> { new RuntimeException("Parallelization of histogram calculation not yet implemented."); }
        );
    }
}
