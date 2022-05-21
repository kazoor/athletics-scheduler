package DataClasses;
import java.util.ArrayList;

public class ScheduleEntries {

    public ArrayList<Entry> GetEntryList() {
        return m_EntryList;
    }

    public void SetEntryList(ArrayList<Entry> m_EntryList) {
        this.m_EntryList = m_EntryList;
    }

    public ArrayList<Entry> m_EntryList = null;

    public ScheduleEntries() {
        m_EntryList = new ArrayList<Entry>();
    }
}
