package dataclasses;
import java.time.LocalDateTime;

public class TimeSlot {

    public LocalDateTime StartTime;
    public LocalDateTime EndTime;

    public TimeSlot (LocalDateTime startTime, LocalDateTime endTime) {
        StartTime = startTime;
        EndTime = endTime;

}
}
