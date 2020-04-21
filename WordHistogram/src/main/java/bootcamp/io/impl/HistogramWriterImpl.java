package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;

import java.util.Map;

public class HistogramWriterImpl implements HistogramWriter {
    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        return new Result();
    }
}
