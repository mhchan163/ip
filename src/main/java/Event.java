import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

/**
 * Event is a type of task that includes a time input in addition to
 * the string description.
 */
public class Event extends Task{
    protected String date;
    protected String time;

    public Event(String description, String dateTimeInput) {
        super(description);
        String[] temp = dateTimeInput.trim().split(" ");
        date = temp[0];
        time = temp[1];
    }

    public static LocalDate stringToDate(String stringDate){
        return LocalDate.parse(stringDate);
    }

    public static LocalTime stringToTime(String stringTime){
        int time = Integer.parseInt(stringTime);
        int hour = time/100;
        int mins = time % 100;
        return LocalTime.of(hour,mins);
    }

    public String getTime(){
        return time;
    }

    public String getDate(){
        return date;
    }


    @Override
    /**
     *Returns the taskCode, description, date and time of the task combined into a string
     *@param none
     *@return String
     */
    public String toString() {
        return taskCode() + super.toString() + " (by: " + stringToDate(date).format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + " " + stringToTime(time).format(DateTimeFormatter.ofPattern("HH:mm a")) + ")";
    }

    public String taskCode(){
        return "[E]";
    }

}
