package bootcamp.io.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.HistogramWriter;

public class HistogramWriterImpl implements HistogramWriter {
    public Result<?> writeHistogram(final Map<String, Integer> histogram, final OutputStream outStream) {
        try {
            final var outputStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
            outputStreamWriter.write(histogram.toString());
            outputStreamWriter.close();
            return new Result<>();
        } catch (IOException exception) {
            return new Result<>(Status.IO_ERROR, exception.getMessage());
        }
    }
}