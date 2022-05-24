package Client;
import CSVParser.CSVParser;
import DataClasses.Entry;
import DataClasses.ScheduleEntries;
import CalculateSchedule.*;

import java.util.ArrayList;

public class Client {
    // Client entrypoint.
    public static void main(String args[]) {

        System.out.println("Client running!");
        CSVParser parser = new CSVParser();
        parser.run("Client/src/registration-list.csv");

        ArrayList<ScheduleEntries> Entries = new ArrayList<ScheduleEntries>();
        Entries.add(parser.GetScheduleEntries());

        Algorithm Alg = new Algorithm(Entries);
        Population Pop = new Population(100, Entries).SortScheduleByQuality();


        Population Modified = new Population(Pop.GetSchedules().size(), Entries);
        int Generation = 0;
        while(Modified.SortScheduleByQuality().GetSchedules().get(0).GetFitness() != 1.0f) {
            Modified = Alg.Evolve(Pop);
            ++Generation;
        }


       for(int i = 0; i < Modified.GetSchedules().get(0).GetSchedule().get(0).GetEntryList().size(); ++i) {
            System.out.println("-------------------------------------------");
            System.out.print(Modified.GetSchedules().get(0).GetSchedule().get(0).GetEntryList().get(i).GetTimeslot().GetStartTime() + " - ");
            System.out.print(Modified.GetSchedules().get(0).GetSchedule().get(0).GetEntryList().get(i).GetTimeslot().GetEndTime() + "\n");
            System.out.println(Modified.GetSchedules().get(0).GetSchedule().get(0).GetEntryList().get(i).GetDiscipline().GetName());
            System.out.println("ID: " + Modified.GetSchedules().get(0).GetSchedule().get(0).GetEntryList().get(i).GetStation().GetId());
            System.out.println("-------------------------------------------");
        }
        System.out.println("Fitness: " + Modified.GetSchedules().get(0).GetFitness() +  " Found at generation: " + Generation);
    }
}