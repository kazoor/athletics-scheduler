package DataClasses;

public class Athlete {
    public String GetClub() {
        return Club;
    }

    public void SetClub(String Club) {
        this.Club = Club;
    }

    String Club;

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    String Name;

    public String GetSurname() {
        return Surname;
    }

    public void SetSurname(String Surname) {
        this.Surname = Surname;
    }

    String Surname;

    public String GetSex() {
        return Sex;
    }

    public void SetSex(String Sex) {
        this.Sex = Sex;
    }

    String Sex;

    public int GetAge() {
        return Age;
    }

    public void SetAge(int Age) {
        this.Age = Age;
    }

    int Age;

    public String GetRunning60() {
        return Running60;
    }

    public void SetRunning60(String Running60) {
        this.Running60 = Running60;
    }

    public String Running60;

    public String GetRunning200() {
        return Running200;
    }

    public void SetRunning200(String Running200) {
        this.Running200 = Running200;
    }

    public String Running200;

    public String GetRunning800() {
        return Running800;
    }

    public void SetRunning800(String Running800) {
        this.Running800 = Running800;
    }

    public String Running800;

    public String GetRunning1500() {
        return Running1500;
    }

    public void SetRunning1500(String Running1500) {
        this.Running1500 = Running1500;
    }

    public String Running1500;

    public String GetRunning3000() {
        return Running3000;
    }

    public void SetRunning3000(String Running3000) {
        this.Running3000 = Running3000;
    }

    public String Running3000;

    public String GetRunningHurdles() {
        return RunningHurdles;
    }

    public void SetRunningHurdles(String RunningHurdles) {
        this.RunningHurdles = RunningHurdles;
    }

    public String RunningHurdles;

    public String GetJumpingLong() {
        return JumpingLong;
    }

    public void SetJumpingLong(String JumpingLong) {
        this.JumpingLong = JumpingLong;
    }

    public String JumpingLong;

    public String GetJumpingTriple() {
        return JumpingTriple;
    }

    public void SetJumpingTriple(String JumpingTriple) {
        this.JumpingTriple = JumpingTriple;
    }

    public String JumpingTriple;

    public String GetJumpingHigh() {
        return JumpingHigh;
    }

    public void SetJumpingHigh(String JumpingHigh) {
        this.JumpingHigh = JumpingHigh;
    }

    public String JumpingHigh;

    public String GetJumpingPole() {
        return JumpingPole;
    }

    public void SetJumpingPole(String JumpingPole) {
        this.JumpingPole = JumpingPole;
    }

    public String JumpingPole;

    public String GetThrowingShot() {
        return ThrowingShot;
    }

    public void SetThrowingShot(String ThrowingShot) {
        this.ThrowingShot = ThrowingShot;
    }

    public String ThrowingShot;

    public Entry GetLastCompetition() {
        return LastCompetition;
    }

    public void SetLastCompetition(Entry LastCompetition) {
        this.LastCompetition = LastCompetition;
    }

    Entry LastCompetition;

    public Athlete (String club, String name, String surname, String sex, int age,String Running60,String Running200,String Running800,String Running1500,String Running3000,
                    String RunningHurdles,String JumpingLong,String JumpingTriple,String JumpingHigh,String JumpingPole,String ThrowingShot, Entry lastCompetition) {
        Club = club;
        Name = name;
        Surname = surname;
        Sex = sex;
        Age = age;
        Running60 = Running60;
        Running200 = Running200;
        Running800 = Running800;
        Running1500 = Running1500;
        Running3000 = Running3000;
        RunningHurdles = RunningHurdles;
        JumpingLong = JumpingLong;
        JumpingTriple = JumpingTriple;
        JumpingHigh = JumpingHigh;
        JumpingPole = JumpingPole;
        ThrowingShot =  ThrowingShot;
        LastCompetition = lastCompetition;
    }
}
