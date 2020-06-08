package bootcamp.process;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HistogramCalculatorTests {
    @Test
    public void canCalculateHistogramFromWordList() {
        final var wordList = Arrays.asList("twinkle", "twinkle", "little", "star");

        final var histogramCalculator = new HistogramCalculator();
        final var histogram = histogramCalculator.calculate(wordList);

        assertThat(histogram.size(), is(3));
        assertThat(histogram.get("twinkle"), is(2));
        assertThat(histogram.get("little"), is(1));
        assertThat(histogram.get("star"), is(1));
    }

    @Test
    public void canCalculateHistogramFromWordListExample2() {
        final var wordList = Arrays.asList("baa", "baa", "black", "sheep", "have", "you", "any", "wool", "yes", "sir",
                "yes", "sir", "three", "bags", "full");

        final var histogramCalculator = new HistogramCalculator();
        final var histogram = histogramCalculator.calculate(wordList);

        assertThat(histogram.size(), is(12));
        assertThat(histogram.get("baa"), is(2));
        assertThat(histogram.get("black"), is(1));
        assertThat(histogram.get("sheep"), is(1));
        assertThat(histogram.get("have"), is(1));
        assertThat(histogram.get("you"), is(1));
        assertThat(histogram.get("any"), is(1));
        assertThat(histogram.get("wool"), is(1));
        assertThat(histogram.get("yes"), is(2));
        assertThat(histogram.get("sir"), is(2));
        assertThat(histogram.get("three"), is(1));
        assertThat(histogram.get("bags"), is(1));
        assertThat(histogram.get("full"), is(1));
    }
}