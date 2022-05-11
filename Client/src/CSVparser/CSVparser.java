package CSVparser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVparser
{
    public static void parser(String path) throws IOException, CsvException {
         String[] storing;
        try(CSVReader reader = new CSVReader(new FileReader("src/Exemple.csv"))) {
            while ((storing = reader.readNext()) != null){
                System.out.println(storing[0]+storing[1]+storing[2]);
            }
        }
    }
    public static void main(String args[]) throws IOException, CsvException {parser("hello");}
}
