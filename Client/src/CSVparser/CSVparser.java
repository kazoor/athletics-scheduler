package CSVparser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;


public class CSVparser {
    public static void parser() throws IOException, CsvException {
        String[] storing;
        try (CSVReader reader = new CSVReader(new FileReader("Client/src/Exemple.csv"))) {
            while ((storing = reader.readNext()) != null) {
                System.out.println(storing[0] + storing[1] + storing[2]);
            }
        }
    }

  void run(){
        try {
            parser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
  }
}
