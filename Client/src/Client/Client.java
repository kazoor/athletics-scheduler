package Client;

import CSVParser.CSVParser;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Client {
    // Client entrypoint.
    public static void main(String args[]) throws IOException, CsvException {
        System.out.println("Client running!");
        CSVParser.parser();
    }
}