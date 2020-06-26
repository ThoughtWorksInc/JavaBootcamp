package bootcamp.process;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HistogramCalculatorTest {

    @Test
    void shouldCorrectlyCountAndMapWordsFromAProvidedList() {
        List<String> words = Arrays.asList("hi", "hello", "greetings", "salutations",
                "hi", "hi", "hello");
        HistogramCalculator histogramCalculator = new HistogramCalculator();
        Map<String, Integer> expectedMapping = new HashMap<>();
        expectedMapping.put("hi", 3);
        expectedMapping.put("hello", 2);
        expectedMapping.put("greetings", 1);
        expectedMapping.put("salutations", 1);
        assertEquals(expectedMapping, histogramCalculator.calculate(words));
    }

    @Test
    void shouldReturnEmptyMapIfGivenAnEmptyListOfWords() {
        List<String> words = new ArrayList<>();
        HistogramCalculator histogramCalculator = new HistogramCalculator();
        assertTrue(histogramCalculator.calculate(words).isEmpty());
    }
}