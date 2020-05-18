package bootcamp.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HistogramCalculator {
    public Map<String, Integer> calculate(final List<String> words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0 ; i < words.size(); i++) {
            String word = words.get(i);
            if (!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                int value = map.get(word);
                map.replace(word, value+1);
            }
        }
        return map;
    }
}
