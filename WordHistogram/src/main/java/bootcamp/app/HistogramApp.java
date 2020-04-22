package bootcamp.app;

import bootcamp.data.Result;
import bootcamp.io.impl.HistogramWriterImpl;
import bootcamp.io.impl.WordReaderImpl;
import bootcamp.process.HistogramProcessor;

import java.io.*;

public class HistogramApp {
    public static void main(final String[] args) {
        //TODO use command line args to get the name of the input and output files.
        //TODO create the HistogramProcessor object and run it to create and save the histogram in a file.
        try (FileInputStream input = new FileInputStream(args[0]);
             FileOutputStream output = new FileOutputStream(args[1])) {

            HistogramProcessor histogramProcessor = new HistogramProcessor(input, output);

            WordReaderImpl wordReader = new WordReaderImpl();
            HistogramWriterImpl histogramWriter = new HistogramWriterImpl();
            Result result = histogramProcessor.process(wordReader, histogramWriter);
            System.out.println(result.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(
                    "File input not found"
            );
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please supply input and output file paths");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
