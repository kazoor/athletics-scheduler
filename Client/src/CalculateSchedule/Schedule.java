package CalculateSchedule;
import DataClasses.Entry;
import DataClasses.ScheduleEntries;

import java.util.ArrayList;
import java.util.Random;

public class Schedule {

    private final int TIME_CONSTRAINT_LO = 10;
    private final int TIME_CONSTRAINT_HI = 22;

    public ArrayList<ScheduleEntries> GetSchedule() {
        return m_Schedule;
    }

    private ArrayList<ScheduleEntries> m_Schedule;

    public int GetConflicts() {
        return m_Conflicts;
    }

    private int m_Conflicts = 0;

    private double m_Fitness = -1;

    private boolean m_HasFitnessChanged = true;

    public Schedule(ArrayList<ScheduleEntries> Entries) {
        m_Schedule = Entries;
    }

    public Schedule Initialize() {
        Random R1 = new Random();
        Random R2 = new Random();
        for(int i = 0; i < m_Schedule.get(0).GetEntryList().size(); ++i) {
            int Random1 = R1.nextInt(TIME_CONSTRAINT_HI - TIME_CONSTRAINT_LO) + TIME_CONSTRAINT_LO;
            int Random2 = R2.nextInt(TIME_CONSTRAINT_HI - TIME_CONSTRAINT_LO) + TIME_CONSTRAINT_LO;
            m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().SetStartTime(Random1);
            m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().SetEndTime(Random2);
        }
        return this;
    }

    public double GetFitness() {
        if(m_HasFitnessChanged) {
            m_Fitness = CalculateFitness();
            m_HasFitnessChanged = false;
        }
        return m_Fitness;
    }

    private double CalculateFitness() {
        m_Conflicts = 0;
        for(int i = 0; i < m_Schedule.size(); ++i) {
            if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() < TIME_CONSTRAINT_LO)
                m_Conflicts++;

            if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() > TIME_CONSTRAINT_HI)
                m_Conflicts++;

           if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() - m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() < 1)
                m_Conflicts++;

            if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() - m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() > 1)
                m_Conflicts++;

            if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() == m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime())
                m_Conflicts++;

            if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() > m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime())
                m_Conflicts++;

            for(int j = i + 1; j < m_Schedule.size(); ++j) {
                if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() == m_Schedule.get(0).GetEntryList().get(j).GetTimeslot().GetStartTime()
                        && m_Schedule.get(0).GetEntryList().get(i).GetStation().GetId() !=  m_Schedule.get(0).GetEntryList().get(j).GetStation().GetId())
                    m_Conflicts++;

                if((Math.abs(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() - m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime())) > 1)
                    m_Conflicts++;

                if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() > m_Schedule.get(0).GetEntryList().get(j).GetTimeslot().GetStartTime() && m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() < m_Schedule.get(0).GetEntryList().get(j).GetTimeslot().GetEndTime())
                    m_Conflicts++;

                if(m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() < m_Schedule.get(0).GetEntryList().get(j).GetTimeslot().GetEndTime() && m_Schedule.get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() > m_Schedule.get(0).GetEntryList().get(j).GetTimeslot().GetStartTime())
                    m_Conflicts++;
            }
        }
            return 1/(double)(m_Conflicts + 1.0f);
    }
}
