package DataClasses;

public class Athlete {
    String m_Club;
    String m_Name;
    String m_Surname;
    String m_Sex;
    int m_Age;
    public String m_Running60;
    public String m_Running200;
    public String m_Running800;
    public String m_Running1500;
    public String m_Running3000;
    public String m_RunningHurdles;
    public String m_JumpingLong;
    public String m_JumpingTriple;
    public String m_JumpingHigh;
    public String m_JumpingPole;
    public String m_ThrowingShot;
    Entry m_LastCompetition;
    public Athlete (String club, String name, String surname, String sex, int age,String Running60,String Running200,String Running800,String Running1500,String Running3000,
                    String RunningHurdles,String JumpingLong,String JumpingTriple,String JumpingHigh,String JumpingPole,String ThrowingShot, Entry lastCompetition) {
        m_Club = club;
        m_Name = name;
        m_Surname = surname;
        m_Sex = sex;
        m_Age = age;
        m_Running60 = Running60;
        m_Running200 = Running200;
        m_Running800 = Running800;
        m_Running1500 = Running1500;
        m_Running3000 = Running3000;
        m_RunningHurdles = RunningHurdles;
        m_JumpingLong = JumpingLong;
        m_JumpingTriple = JumpingTriple;
        m_JumpingHigh = JumpingHigh;
        m_JumpingPole = JumpingPole;
        m_ThrowingShot =  ThrowingShot;
        m_LastCompetition = lastCompetition;
    }
}
