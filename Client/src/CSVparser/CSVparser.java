package CSVparser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;

public class CSVparser
{
    public static String p = "src/Exemple.csv";
    public static void parser(String path) throws IOException, CsvException {
         String[] storing;
        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            while ((storing = reader.readNext()) != null){
                System.out.println(storing[0]+storing[1]+storing[2]);
            }
        }
    }
    public static void main(String args[]) throws IOException, CsvException {parser(p);}
}
