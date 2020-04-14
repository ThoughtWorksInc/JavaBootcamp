package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class HistogramWriterImpl implements HistogramWriter {
    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram, OutputStream outStream) {
        try (
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outStream));
        ) {
            for (String key : histogram.keySet()) {
                bufferedWriter.write(key + ":" + histogram.get(key) + "\n");
            }

            return new Result();
        } catch(IOException e) {
            return new Result();
        }
    }
}
