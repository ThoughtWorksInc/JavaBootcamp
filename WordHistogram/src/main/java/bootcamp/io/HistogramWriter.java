package bootcamp.io;

import bootcamp.data.Result;

import java.io.OutputStream;
import java.util.Map;

public interface HistogramWriter {
    Result<?> writeHistogram(final Map<String, Integer> histogram, OutputStream outputStream);
}
