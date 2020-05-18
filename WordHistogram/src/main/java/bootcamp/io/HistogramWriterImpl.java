package bootcamp.io;

import bootcamp.data.Result;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class HistogramWriterImpl implements HistogramWriter {

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram, OutputStream outStream) {
        histogram.forEach((k, v) -> {
                    try {
                        String line = k + " : " + v;
                        outStream.write(line.getBytes());
                        outStream.write("\n".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    return new Result();
    }

}
