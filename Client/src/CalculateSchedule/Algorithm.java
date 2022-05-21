package CalculateSchedule;

import DataClasses.ScheduleEntries;

import java.util.ArrayList;

public class Algorithm {

    private static final int POP_SIZE = 9;
    private static double CROSS_RATE = 0.9f;
    private static double MUTATION_RATE = 0.1f;
    private static final int SELECTION_SIZE = 3;
    private static final int FINAL_SCHEDULES = 1;
    private ArrayList<ScheduleEntries> m_Entries;

    public Algorithm(ArrayList<ScheduleEntries> Entries) {
        this.m_Entries  = Entries;
    }

    Population CrossPopulation(Population Pop) {
        Population Cross = new Population(Pop.GetSchedules().size(), m_Entries);
        for(int i = 0; i < FINAL_SCHEDULES; ++i) {
            Cross.GetSchedules().set(i, Pop.GetSchedules().get(i));
        }

        for(int i = FINAL_SCHEDULES; i < Pop.GetSchedules().size(); ++i) {
            if(Math.random() < CROSS_RATE) {
                Schedule Sched1 = new Schedule(m_Entries); //GetTournamentPopulation(Pop).SortScheduleByQuality().GetSchedules().get(0);
                Schedule Sched2 = new Schedule(m_Entries); //GetTournamentPopulation(Pop).SortScheduleByQuality().GetSchedules().get(0);

                Cross.GetSchedules().set(i, CrossSchedule(Sched1, Sched2));
            } else {
                Cross.GetSchedules().set(i, Pop.GetSchedules().get(i));
            }
        }
        return Cross;
    }

    Schedule CrossSchedule(Schedule Sched1, Schedule Sched2) {
        Schedule Cross = new Schedule(m_Entries).Initialize();

        for(int i = 0; i < Cross.GetSchedule().size(); ++i) {
            if(Math.random() > 0.5f)
                Cross.GetSchedule().set(i, Sched1.GetSchedule().get(i));
            else
                Cross.GetSchedule().set(i, Sched2.GetSchedule().get(i));
        }
        return Cross;
    }

    Population MutatePopulation(Population Pop) {
        Population MutatedPopulation = new Population(Pop.GetSchedules().size(), m_Entries);
        ArrayList<Schedule> Schedules = MutatedPopulation.GetSchedules();

        for(int i = 0; i < FINAL_SCHEDULES; ++i) {
            Schedules.set(i, Pop.GetSchedules().get(i));
        }

        for(int i = FINAL_SCHEDULES; i < Pop.GetSchedules().size(); ++i) {
            Schedules.set(i, MutateSchedule(Pop.GetSchedules().get(i)));
        }

        return MutatedPopulation;
    }

    Schedule MutateSchedule(Schedule Sched) {
        Schedule Sched1 = new Schedule(m_Entries).Initialize();

        for(int i = 0; i < Sched.GetSchedule().size(); ++i) {
            if(Math.random() < MUTATION_RATE)
                Sched.GetSchedule().set(i, Sched1.GetSchedule().get(i));
        }
        return Sched;
    }

    Population GetTournamentPopulation(Population Pop) {
        Population TournamentPopulation = new Population(SELECTION_SIZE, m_Entries);
        for(int i = 0; i < SELECTION_SIZE; ++i) {
            TournamentPopulation.GetSchedules().set(i, Pop.GetSchedules().get((int)(Math.random() * Pop.GetSchedules().size())));
        }

        return null;
    }

    public Population Evolve(Population Pop) {
        return MutatePopulation(CrossPopulation(Pop));
    }
}
