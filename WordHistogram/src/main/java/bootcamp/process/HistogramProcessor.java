package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

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
        Map<String,Integer> histogramMap = calculator.calculate(wordsResult.getValue().get());
        return writer.writeHistogram(histogramMap, outputStream);
    }
}
