package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramCalculator {

    public Map<String, Integer> calculate(final List<String> words) {
        Map<String, Integer> histogram = new HashMap<>();
        for (String s : words) {
            if(!histogram.containsKey(s)){
                histogram.put(s, 1);
            } else {
                int count = histogram.get(s);
                histogram.put(s, count + 1);
            }
        }
        return histogram;
    }
}
