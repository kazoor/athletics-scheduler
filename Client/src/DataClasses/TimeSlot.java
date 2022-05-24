package DataClasses;

public class TimeSlot {

    public int GetStartTime() {
        return m_StartTime;
    }

    public void SetStartTime(int m_StartTime) {
        this.m_StartTime = m_StartTime;
    }

    public int m_StartTime;

    public int GetEndTime() {
        return m_EndTime;
    }

    public void SetEndTime(int m_EndTime) {
        this.m_EndTime = m_EndTime;
    }

    public int m_EndTime;

    public TimeSlot (int startTime, int endTime) {
        m_StartTime = startTime;
        m_EndTime = endTime;
    }
}
