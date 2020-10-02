package tasks;

import exception.DukeException;
import exception.WrongEventDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

/**
 * Event is a type of task that includes a time input in addition to
 * the string description.
 */
public class Event extends Task{
    protected String date;
    protected String firstTimeFrame;
    protected String secondTimeFrame;

    /**
     * The constructor for the Event class, the time string input is
     * split from a particular time frame to two different time inputs
     * to be used later for conversion into a different time format.
     * @param description
     * @param dateTimeInput
     * @throws DukeException
     */
    public Event(String description, String dateTimeInput) throws DukeException {
        super(description);
        if(!dateTimeInput.contains("-")){
            throw new WrongEventDateFormatException();
        } else {
            String[] temp = dateTimeInput.trim().split(" ");
            date = temp[0];
            String time = temp[1];
            if(!time.contains("-")){
                throw new WrongEventDateFormatException();
            } else {
                String[] timeFrame = time.trim().split("-");
                firstTimeFrame = timeFrame[0];
                secondTimeFrame = timeFrame[1];
            }
        }
    }

    public static LocalDate stringToDate(String stringDate) {
            return LocalDate.parse(stringDate);
    }

    /**
     * The string input of the time will converted to a integer
     * and split into time and hour to be converted to an object
     * of type LocalTime.
     * @param stringTime
     * @return the time input as LocalTime
     */
    public static LocalTime stringToTime(String stringTime){
        int hour;
        int mins;
        String properString;
        if(stringTime.contains(":")){
            properString = stringTime.replaceAll(":","");
        } else {
            properString = stringTime;
        }
        int time = Integer.parseInt(properString);
        hour = time / 100;
        mins = time % 100;

        return LocalTime.of(hour,mins);
    }

    public String getTime(){
        return firstTimeFrame + "-" + secondTimeFrame;
    }

    public String getDate(){
        return date;
    }


    @Override
    /**
     *Returns the taskCode, description, date and time of the task combined into a string.
     * The date and time is reformatted into a different format. e.g from 2020-01-01 1800-2000
     * to 1 Jan 2020 6:00PM - 8:00PM.
     *@param none
     *@return String
     */
    public String toString() {
        return taskCode() + super.toString() + " (by: " + stringToDate(date).format(DateTimeFormatter.ofPattern("MMM dd yyyy")) +
                " " + stringToTime(firstTimeFrame).format(DateTimeFormatter.ofPattern("hh:mm a")) +
                "-" + stringToTime(secondTimeFrame).format(DateTimeFormatter.ofPattern("hh:mm a")) + ")";
    }

    public String taskCode(){
        return "[E]";
    }

}
