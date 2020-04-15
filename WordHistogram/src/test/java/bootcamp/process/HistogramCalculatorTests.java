package bootcamp.process;

import bootcamp.process.HistogramCalculator;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HistogramCalculatorTests {
    @Test
    public void testCalculate() {
        List<String> wordList = List.of("the", "dog", "is", "the", "best", "dog", "in", "the", "world");
        Map<String, Integer> expectedHistogramMap = new HashMap<>();
        expectedHistogramMap.put("the", 3);
        expectedHistogramMap.put("dog", 2);
        expectedHistogramMap.put("is", 1);
        expectedHistogramMap.put("best", 1);
        expectedHistogramMap.put("in", 1);
        expectedHistogramMap.put("world", 1);
        assertEquals(expectedHistogramMap, new HistogramCalculator().calculate(wordList));
    }
}
