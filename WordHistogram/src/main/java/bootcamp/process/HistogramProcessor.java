package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();
    final File inputFile;
    final File outputFile;

    public HistogramProcessor(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public Result<?> process(final WordReader reader, final HistogramWriter writer) throws IOException {
        Result<List<String>> list = reader.getWords(new FileInputStream(this.inputFile));
        Map<String, Integer> map = calculator.calculate(list.getValue().get());
        writer.writeHistogram(map, new FileOutputStream(this.outputFile));
        return new Result();
    }
}
