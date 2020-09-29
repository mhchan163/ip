import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * Deadline is a type of task that involves a time input in addition to
 * the string description.
 */
public class Deadline extends Task{
    protected String date;
    protected String time;

    public Deadline(String description, String dateTimeInput) {
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
        return "[D]";
    }


}
