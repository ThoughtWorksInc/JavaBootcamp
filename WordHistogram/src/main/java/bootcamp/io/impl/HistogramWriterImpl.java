package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.HistogramWriter;

import java.io.*;
import java.util.Map;

public class HistogramWriterImpl implements HistogramWriter {
    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram, OutputStream output) {
        try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(output))) {
            bos.write(histogram.toString());
        } catch (IOException e) {
            return new Result(Status.IO_ERROR, e.getMessage());
        }
        return new Result();
    }
}
