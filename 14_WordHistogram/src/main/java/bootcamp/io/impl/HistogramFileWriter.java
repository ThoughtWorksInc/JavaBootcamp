package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

public class HistogramFileWriter extends HistogramWriter {

    public HistogramFileWriter(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        PrintWriter writer = new PrintWriter(this.outStream);
        histogram.forEach((s, i) -> writer.println(s + " " + i));
        writer.close();
        return new Result<>();
    }

    public void close() throws Exception {
        this.outStream.close();
    }
}
