package DataClasses;

public class Station {
    public int GetId() {
        return m_Id;
    }

    public void SetId(int Id) {
        this.m_Id = Id;
    }

    int m_Id;
    public Station(int Id) {
        m_Id = Id;
    }
}
