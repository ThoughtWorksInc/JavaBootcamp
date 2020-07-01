package bootcamp.io;

import bootcamp.data.Result;
import bootcamp.data.Status;

import java.io.*;
import java.util.Collection;
import java.util.Map;

public class HistogramWriterImpl extends HistogramWriter {

    public HistogramWriterImpl(OutputStream outStream) {
        super(outStream);
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        try (Writer outputStreamWriter = new OutputStreamWriter(getOutStream())){
            outputStreamWriter.write(histogram.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(Status.IO_ERROR, "There was a problem writing to file");
        }
        return new Result();
    }
}
