package DataClasses;

public class Discipline {
    public String GetName() {
        return m_Name;
    }

    public void SetName(String m_Name) {
        this.m_Name = m_Name;
    }

    String m_Name;
    public Discipline(String name) {
         m_Name = name;
    }
}
