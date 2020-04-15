package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();
    public InputStream inputStream;
    public OutputStream outputStream;

    public HistogramProcessor(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public Result<?> process(final WordReader reader, final HistogramWriter writer) throws IOException {
        Result<List<String>> wordsResult = reader.getWords(inputStream);
        Optional<List<String>> wordsList = wordsResult.getValue();
        if (wordsList.isPresent()) {
            List<String> foundWordsList = wordsList.get();
            Map<String, Integer> histogramMap = calculator.calculate(foundWordsList);
            return writer.writeHistogram(histogramMap, outputStream);
        } else {
            return wordsResult;
        }
    }
}
