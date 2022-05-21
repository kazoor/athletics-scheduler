package CalculateSchedule;
import DataClasses.ScheduleEntries;

import java.util.ArrayList;

public class Population {
    public ArrayList<Schedule> GetSchedules() {
        return m_Schedules;
    }

    private ArrayList<Schedule> m_Schedules;

    public Population(int PopulationSize, ArrayList<ScheduleEntries> Entries) {
        m_Schedules = new ArrayList<Schedule>(PopulationSize);
        for(int i = 0; i <= PopulationSize; ++i) {
            m_Schedules.add(new Schedule(Entries).Initialize());
        }
    }

    public Population SortScheduleByQuality() {
        m_Schedules.sort((sched1, sched2) -> {
            int Ret = 0;
            if(sched1.GetFitness() > sched2.GetFitness())
                Ret = -1;
            else if(sched1.GetFitness() < sched2.GetFitness())
                Ret = 1;

            return Ret;
        });
        return this;
    }
}
