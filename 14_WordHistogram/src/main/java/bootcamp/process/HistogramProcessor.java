package bootcamp.process;

import java.io.InputStream;
import java.io.OutputStream;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

public class HistogramProcessor {
    final HistogramCalculator histogramCalculator;
    final WordReader reader;
    final HistogramWriter writer;

    public HistogramProcessor(final WordReader reader, final HistogramWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.histogramCalculator = new HistogramCalculator();
    }

    public Result<?> process(InputStream inputStream, OutputStream outputStream) {
        final var wordListResult = reader.getWords(inputStream);

        if (wordListResult.status != Status.SUCCESS) {
            return new Result<>(Status.READ_ERROR, wordListResult.message);
        }

        final var histogram = histogramCalculator.calculate(wordListResult.value.get());
        final var writeResult = writer.writeHistogram(histogram, outputStream);

        if (writeResult.status != Status.SUCCESS) {
            return new Result<>(Status.WRITE_ERROR, writeResult.message);
        }

        return new Result<>();
    }

}
