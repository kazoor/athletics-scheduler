package dataclasses;
import java.time.LocalDateTime;

public class TimeSlot {

    public LocalDateTime m_StartTime;
    public LocalDateTime m_EndTime;

    public TimeSlot (LocalDateTime startTime, LocalDateTime endTime) {
        m_StartTime = startTime;
        m_EndTime = endTime;

}
}
