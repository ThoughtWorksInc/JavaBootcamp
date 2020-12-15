package bootcamp.io;

import bootcamp.data.Result;

import java.io.OutputStream;
import java.util.Map;

public abstract class HistogramWriter {
    public final OutputStream outStream;

    public HistogramWriter(final OutputStream outStream) {
        this.outStream = outStream;
    }

    public abstract Result<?> writeHistogram(final Map<String, Integer> histogram);
}
