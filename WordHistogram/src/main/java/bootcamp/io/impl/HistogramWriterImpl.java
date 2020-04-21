package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;

import java.io.*;
import java.util.Map;

public class HistogramWriterImpl implements HistogramWriter {
    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram, OutputStream output) {
        try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(output))) {
            bos.write(histogram.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result();
    }
}
