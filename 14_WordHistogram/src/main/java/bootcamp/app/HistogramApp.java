package bootcamp.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import bootcamp.data.Status;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;
import bootcamp.io.impl.HistogramWriterImpl;
import bootcamp.io.impl.WordReaderImpl;
import bootcamp.process.HistogramProcessor;

public class HistogramApp {
    public static void main(final String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            throw new RuntimeException("Argument format: [path_to_input_file] [path_to_output_file]");
        }

        final WordReader wordReader = new WordReaderImpl();
        final HistogramWriter histogramWriter = new HistogramWriterImpl();
        final var histogramProcessor = new HistogramProcessor(wordReader, histogramWriter);

        final var result = histogramProcessor.process(new FileInputStream(args[0]), new FileOutputStream(args[1]));

        if (result.status == Status.SUCCESS) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
            System.exit(1);
        }
    }
}
