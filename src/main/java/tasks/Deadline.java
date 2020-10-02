package tasks;

import exception.DukeException;
import exception.WrongDeadlineDateFormatException;
import storage.Storage;
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

    /**
     * The string input of the time will converted to a integer
     * and split into time and hour to be converted to an object
     * of type LocalTime
     * @param stringTime
     * @return the time input as LocalTime
     */
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
    /**
     *Returns the taskCode, description, date and time of the task combined into a string
     *@param none
     *@return String
     */
    public String toString() {
        return taskCode() + super.toString() + " (by: " + stringToDate(date).format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + " " + stringToTime(time).format(DateTimeFormatter.ofPattern("hh:mm a")) + ")";

    }

    public String taskCode(){
        return "[D]";
    }


}
