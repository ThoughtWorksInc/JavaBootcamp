package bootcamp.io;

import bootcamp.data.Result;
import bootcamp.data.Status;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class HWriter extends HistogramWriter {

    public HWriter(OutputStream outStream) {
        super(outStream);

        // what is super?
    }

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram) {
        try {
            var writer = new OutputStreamWriter(super.getOutStream());
            writer.write(histogram.toString());
            return new Result<>(Status.Success, "");

        } catch (IOException e) {

            return new Result<>(Status.IOError, e.getMessage());
        }
    }
}
