import bootcamp.process.HistogramCalculator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HistogramCalculatorTest {

    private List<String> testList;
    private HistogramCalculator testCalculator;

    @Before
    public void setUp() {
        testList = Arrays.asList("test", "test", "test", "123");
        testCalculator = new HistogramCalculator();

    }

    @Test
    public void calculator_returns_histogram_of_list_in_map_format() {
        Map<String, Integer> result = testCalculator.calculate(testList);
        assertThat(result.get("test"), is(3));
        assertThat(result.get("123"), is(1));
    }
}
