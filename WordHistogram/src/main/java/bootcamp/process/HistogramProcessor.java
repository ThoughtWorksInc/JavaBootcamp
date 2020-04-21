package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();
    private InputStream inputStream;
    private OutputStream outputStream;


    public HistogramProcessor(InputStream inputStream, OutputStream outputStream) {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
    }

    public Result<?> process(final WordReader wordReader, final HistogramWriter writer) {
        Result<List<String>> words = wordReader.getWords(inputStream);
        Map<String, Integer> histogramMap = calculator.calculate(words.getValue().get());
        writer.writeHistogram(histogramMap);
        return new Result();
    }
}
