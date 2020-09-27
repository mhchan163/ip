import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Deadline extends Task{
    protected LocalDate date;
    protected String time;

    public Deadline(String description, String dateTimeInput) {
        super(description);
        String[] temp = dateTimeInput.split(" ");
        date = LocalDate.parse(temp[0]);
        time = temp[1];
    }

    public String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        return df.format(time);
    }

    @Override
    public String toString() {
        return taskCode() + super.toString() + " (by: " + date.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + getTime()  + ")";
    }

    public String taskCode(){
        return "[D]";
    }


}
