package Client;
import CSVparser.CSVparser;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, CsvException {
        //String fileName = "Client/src/Exemple.csv";
        System.out.println("Client running!");
        CSVparser.parser();
    }
}