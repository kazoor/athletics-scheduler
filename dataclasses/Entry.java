package dataclasses;
import java.sql.Time;
import java.util.ArrayList;

public class Entry {
    ArrayList<Athlete> m_athlete;
    Discipline m_discipline;
    TimeSlot m_timeslot;
    Station m_station;
    public Entry(ArrayList<Athlete> athlete, Discipline discipline, TimeSlot timeslot, Station station) {
        m_athlete = athlete;
        m_discipline = discipline;
        m_timeslot = timeslot;
        m_station = station;
    }
}
