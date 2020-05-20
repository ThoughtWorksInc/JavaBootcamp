package bootcamp.io;

import bootcamp.data.Result;
import bootcamp.data.Status;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class HistogramWriterImpl implements HistogramWriter {

    @Override
    public Result<?> writeHistogram(Map<String, Integer> histogram, OutputStream outStream) {
        AtomicReference<String> toWrite = new AtomicReference<>("");
        histogram.forEach((k, v) -> {
                        String line = k + " : " + v;
                        toWrite.getAndSet(toWrite.get() + line + "\n");

                }
        );
        try {
            outStream.write(toWrite.get().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return new Result("There was an error",Status.IOError);
        }

        return new Result(Optional.of(toWrite.get()));
    }

}
