package bootcamp.app;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import bootcamp.process.HistogramProcessor;

import java.io.*;
import java.util.Map;

public class HistogramApp {
    public static void main(final String[] args) throws IOException {

        //TODO use command line args to get the name of the input and output files.
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        WordReaderImpl reader = new WordReaderImpl();
        HistogramWriterImpl writer = new HistogramWriterImpl();

        //TODO create the HistogramProcessor object and run it to create and save the histogram in a file.
        HistogramProcessor processor = new HistogramProcessor(inputFile, outputFile);
        processor.process(reader, writer);


    }
}
