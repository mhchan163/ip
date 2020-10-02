package tasks;

import exception.DukeException;
import exception.WrongDeadlineDateFormatException;
import storage.Storage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Deadline extends Task{
    protected String date;
    protected String time;

    public Deadline(String description, String dateTimeInput)throws DukeException {
        super(description);
        if(!dateTimeInput.contains("-")){
            throw new WrongDeadlineDateFormatException();
        } else {
            String[] temp = dateTimeInput.trim().split(" ");
            date = temp[0];
            time = temp[1];
        }
    }

    public static LocalDate stringToDate(String stringDate) {
            return LocalDate.parse(stringDate);
    }


    public static LocalTime stringToTime(String stringTime){
        int hour;
        int mins;
        String properString;
        if(stringTime.contains(":")){
            properString = stringTime.replace(":","");
        } else {
            properString = stringTime;
        }
        int time = Integer.parseInt(properString);
        hour = time / 100;
        mins = time % 100;

        return LocalTime.of(hour,mins);
    }

    public String getTime(){
        return time;
    }

    public String getDate(){
        return date;
    }

    @Override
    public String toString() {
        return taskCode() + super.toString() + " (by: " + stringToDate(date).format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + " " + stringToTime(time).format(DateTimeFormatter.ofPattern("hh:mm a")) + ")";

    }

    public String taskCode(){
        return "[D]";
    }


}
