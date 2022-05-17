package dataclasses;
import java.time.LocalDateTime;

public class TimeSlot {
    String Name;
    String StationType_;
    public LocalDateTime StartTime;
    public LocalDateTime EndTime;

    public TimeSlot (String name, String stationType_) {
    Name = name;
    StationType_ = stationType_;

}
}
