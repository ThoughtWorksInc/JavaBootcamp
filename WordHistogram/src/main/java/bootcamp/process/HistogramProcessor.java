package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;
import jdk.nashorn.internal.runtime.options.Option;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();
    final InputStream inputStream;
    final OutputStream outputStream;

    public HistogramProcessor(InputStream inputFile, OutputStream outputFile) {
        this.inputStream = inputFile;
        this.outputStream = outputFile;
    }

    public Result<?> process(final WordReader reader, final HistogramWriter writer) throws IOException {
        Result<List<String>> list = reader.getWords(this.inputStream);
        Map<String, Integer> map = calculator.calculate(list.getValue().get());
        return writer.writeHistogram(map, outputStream);
    }
}
