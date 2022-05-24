package DataClasses;
import java.util.ArrayList;

public class Entry {
    ArrayList<Athlete> m_Athlete;
    Discipline m_Discipline;
    TimeSlot m_Timeslot;
    Station m_Station;

    public ArrayList<Athlete> GetAthletes() {
        return m_Athlete;
    }

    public Discipline GetDiscipline() {
        return m_Discipline;
    }

    public TimeSlot GetTimeslot() {
        return m_Timeslot;
    }

    public Station GetStation() {
        return m_Station;
    }

    public Entry(ArrayList<Athlete> athlete, Discipline discipline, TimeSlot timeslot, Station station) {
        m_Athlete = athlete;
        m_Discipline = discipline;
        m_Timeslot = timeslot;
        m_Station = station;
    }
}
