package CSVParser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import DataClasses.Athlete;
import DataClasses.Entry;

import java.io.FileReader;
import java.io.IOException;

public class CSVParser {
    public static void parser() throws IOException, CsvException {
        String[] storing;
        Entry entry;
        try (CSVReader reader = new CSVReaderBuilder(new FileReader("Client/src/registration-list.csv"))
                .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS).build()) {
            while ((storing = reader.readNext()) != null) {
                Athlete Athlete = new Athlete(storing[0], storing[1], storing[2], storing[3], Integer.parseInt(storing[4]), storing[5], storing[6],
                        storing[7], storing[8], storing[9], storing[10], storing[11], storing[12], storing[13] ,storing[14], storing[15],null);
                System.out.println(storing[0] + " " + storing[1] + " " + storing[2] + " " + storing[3] + " " + storing[4] + " " + storing[5] + " " + storing[6] + " " + storing[7] + " " + storing[8] + " " + storing[9] + " " + storing[10] + " " + storing[11] + " " + storing[12] + " " + storing[13] + " " + storing[14] + " " + storing[15]);
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
