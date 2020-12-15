package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();

    public Result<?> process(final WordReader reader, final HistogramWriter writer) throws IOException {
        Result<List<String>> result = reader.getWords();
        Map<String, Integer> words = this.calculator.calculate(result.getValue().orElse(new ArrayList<>()));
        return writer.writeHistogram(words);
    }
}
