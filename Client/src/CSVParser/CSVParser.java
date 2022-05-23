package CSVParser;

import DataClasses.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

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
        if (!Objects.equals(ath.GetRunning60(), "null")){
            m_Running60.add(ath);
        }
        if (!Objects.equals(ath.GetRunning200(), "null")){
            m_Running200.add(ath);
        }
        if (!Objects.equals(ath.GetRunning800(), "null")){
            m_Running800.add(ath);
        }
        if (!Objects.equals(ath.GetRunning1500(), "null")){
            m_Running1500.add(ath);
        }
        if (!Objects.equals(ath.GetRunning3000(), "null")){
            m_Running3000.add(ath);
        }
        if (!Objects.equals(ath.GetRunningHurdles(), "null")){
            m_RunningHurdles.add(ath);
        }
        if (!Objects.equals(ath.GetJumpingLong(), "null")){
            m_JumpingLong.add(ath);
        }
        if (!Objects.equals(ath.GetJumpingTriple(), "null")){
            m_JumpingTriple.add(ath);
        }
        if (!Objects.equals(ath.GetJumpingHigh(), "null")){
            m_JumpingHigh.add(ath);
        }
        if (!Objects.equals(ath.GetJumpingPole(), "null")){
            m_JumpingPole.add(ath);
        }
        if (!Objects.equals(ath.GetThrowingShot(), "null")){
            m_ThrowingShot.add(ath);
        }
    }

    public static void parser(String FilePath) throws IOException, CsvException {
        String[] storing;
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(FilePath))
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
    Discipline Discipline10 = new Discipline("Pole jumping");
    Discipline Discipline11 = new Discipline("Shot throwing");
    Discipline Discipline12 = new Discipline("Ceremony");

    public ScheduleEntries GetScheduleEntries() {
        ScheduleEntries Entries = new ScheduleEntries();
        Entries.m_EntryList.add(new Entry(m_Running60,Discipline1, new TimeSlot(0, 0),  new Station(1)));
        Entries.m_EntryList.add(new Entry(m_Running200,Discipline2,new TimeSlot(0, 0), new Station(2)));
        Entries.m_EntryList.add(new Entry(m_Running800,Discipline3,new TimeSlot(0, 0), new Station(3)));
        Entries.m_EntryList.add(new Entry(m_Running1500,Discipline4,new TimeSlot(0, 0), new Station(4)));
        Entries.m_EntryList.add(new Entry(m_Running3000,Discipline5,new TimeSlot(0, 0), new Station(5)));
        Entries.m_EntryList.add(new Entry(m_RunningHurdles,Discipline6,new TimeSlot(0, 0), new Station(6)));
        Entries.m_EntryList.add(new Entry(m_JumpingLong,Discipline7,new TimeSlot(0, 0), new Station(7)));
        Entries.m_EntryList.add(new Entry(m_JumpingTriple,Discipline8,new TimeSlot(0, 0), new Station(8)));
        Entries.m_EntryList.add(new Entry(m_JumpingHigh,Discipline9,new TimeSlot(0, 0), new Station(9)));
        Entries.m_EntryList.add(new Entry(m_JumpingPole,Discipline10,new TimeSlot(0, 0), new Station(10)));
        Entries.m_EntryList.add(new Entry(m_ThrowingShot,Discipline11,new TimeSlot(0, 0), new Station(11)));
        Entries.m_EntryList.add(new Entry(null, Discipline12,new TimeSlot(0, 0), new Station(12)));

        return Entries;
    }

    public static void run(String FilePath){
        try {
            parser(FilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
