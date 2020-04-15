package bootcamp.app;

import bootcamp.io.impl.HistogramWriterImpl;
import bootcamp.io.impl.WordReaderImpl;
import bootcamp.process.HistogramProcessor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HistogramApp {
    public static void main(final String[] args) throws IOException {
        if (args.length != 2) {
            System.out.print("Incorrect number of arguments given: Provide 2 files - one for input, one for output.");
        }

        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream((args[1]));

        WordReaderImpl wordReader = new WordReaderImpl();
        HistogramWriterImpl histogramWriter = new HistogramWriterImpl();

        HistogramProcessor processor = new HistogramProcessor(inputStream, outputStream);
        processor.process(wordReader, histogramWriter);
    }
}
