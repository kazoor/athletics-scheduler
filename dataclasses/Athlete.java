package dataclasses;

public class Athlete {
    String Name;
    String Gender;
    int Age;
    Entry LastCompetition;
    public Athlete (String name, String gender, int age, Entry lastCompetition) {
        Name = name;
        Gender = gender;
        Age = age;
        LastCompetition = lastCompetition;
    }
}
