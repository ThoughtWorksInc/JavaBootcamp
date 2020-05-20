import bootcamp.process.HistogramCalculator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HistogramCalculatorTests {

    HistogramCalculator calc = new HistogramCalculator();
    ArrayList<String> list = new ArrayList<String>();

    @Before
    public void init() {
        list.clear();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");
        list.add("three");
        list.add("three");
        list.add("four");
        list.add("four");
        list.add("four");
        list.add("four");
    }


    @Test
    public void calculateNumberOfWordsCorrectly() {
        HistogramCalculator calc = new HistogramCalculator();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        assertEquals(map, calc.calculate(list));
    }
}
