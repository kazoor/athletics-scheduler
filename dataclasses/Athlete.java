package dataclasses;

public class Athlete {
    String m_Club;
    String m_Name;
    String m_Surname;
    String m_Sex;
    int m_Age;
    Entry m_LastCompetition;
    public Athlete (String club, String name, String surname, String sex, int age, Entry lastCompetition) {
        m_Club = club;
        m_Name = name;
        m_Surname = surname;
        m_Sex = sex;
        m_Age = age;
        m_LastCompetition = lastCompetition;
    }
}
