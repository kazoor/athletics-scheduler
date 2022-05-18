package CSVParser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import DataClasses.Athlete;
import DataClasses.Entry;
import DataClasses.Discipline;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CSVParser {
    static ArrayList<Athlete> m_Running60 = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_Running200 = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_Running800 = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_Running1500 = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_Running3000 = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_RunningHurdles = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_JumpingLong = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_JumpingTriple = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_JumpingHigh = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_JumpingPole = new ArrayList<Athlete>();
    static ArrayList<Athlete> m_ThrowingShot = new ArrayList<Athlete>();

    public static void SortingAthlete(Athlete ath){
        if (!Objects.equals(ath.m_Running60, "null")){
            m_Running60.add(ath);
        }
        if (!Objects.equals(ath.m_Running200, "null")){
            m_Running200.add(ath);
        }
        if (!Objects.equals(ath.m_Running800, "null")){
            m_Running800.add(ath);
        }
        if (!Objects.equals(ath.m_Running1500, "null")){
            m_Running1500.add(ath);
        }
        if (!Objects.equals(ath.m_Running3000, "null")){
            m_Running3000.add(ath);
        }
        if (!Objects.equals(ath.m_RunningHurdles, "null")){
            m_RunningHurdles.add(ath);
        }
        if (!Objects.equals(ath.m_JumpingLong, "null")){
            m_JumpingLong.add(ath);
        }
        if (!Objects.equals(ath.m_JumpingTriple, "null")){
            m_JumpingTriple.add(ath);
        }
        if (!Objects.equals(ath.m_JumpingHigh, "null")){
            m_JumpingHigh.add(ath);
        }
        if (!Objects.equals(ath.m_JumpingPole, "null")){
            m_JumpingPole.add(ath);
        }
        if (!Objects.equals(ath.m_ThrowingShot, "null")){
            m_ThrowingShot.add(ath);
        }
    }

    public static void parser() throws IOException, CsvException {
        String[] storing;
        try (CSVReader reader = new CSVReaderBuilder(new FileReader("Client/src/registration-list.csv"))
                .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS).build()) {
            while ((storing = reader.readNext()) != null) {
                Athlete Athlete = new Athlete(storing[0], storing[1], storing[2], storing[3], Integer.parseInt(storing[4]), storing[5], storing[6],
                        storing[7], storing[8], storing[9], storing[10], storing[11], storing[12], storing[13] ,storing[14], storing[15],null);
                System.out.println(storing[0] + " " + storing[1] + " " + storing[2] + " " + storing[3] + " " + storing[4] + " " + storing[5] + " " + storing[6] + " " + storing[7] + " " + storing[8] + " " + storing[9] + " " + storing[10] + " " + storing[11] + " " + storing[12] + " " + storing[13] + " " + storing[14] + " " + storing[15]);
                SortingAthlete(Athlete);
            }
        }
    }
    Discipline Discipline1 = new Discipline("60m sprint");
    Discipline Discipline2 = new Discipline("200m sprint");
    Discipline Discipline3 = new Discipline("800m running");
    Discipline Discipline4 = new Discipline("1500m running");
    Discipline Discipline5 = new Discipline("3000m running");
    Discipline Discipline6 = new Discipline("60m hurdles running");
    Discipline Discipline7 = new Discipline("Long jumping");
    Discipline Discipline8 = new Discipline("Triple jumping");
    Discipline Discipline9 = new Discipline("High jumping");
    Discipline Discipline10 = new Discipline("pole jumping");
    Discipline Discipline11 = new Discipline("Shot throwing");

    Entry Running60 = new Entry(m_Running60,Discipline1,null,null);
    Entry Running200 = new Entry(m_Running200,Discipline2,null,null);
    Entry Running800 = new Entry(m_Running800,Discipline3,null,null);
    Entry Running1500 = new Entry(m_Running1500,Discipline4,null,null);
    Entry Running3000 = new Entry(m_Running3000,Discipline5,null,null);
    Entry RunningHurdles = new Entry(m_RunningHurdles,Discipline6,null,null);
    Entry JumpingLong = new Entry(m_JumpingLong,Discipline7,null,null);
    Entry JumpingTriple = new Entry(m_JumpingTriple,Discipline8,null,null);
    Entry JumpingHigh = new Entry(m_JumpingHigh,Discipline9,null,null);
    Entry JumpingPole = new Entry(m_JumpingPole,Discipline10,null,null);
    Entry ThrowingShot = new Entry(m_ThrowingShot,Discipline11,null,null);

    void run(){
        try {
            parser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
