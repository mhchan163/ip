package tasks;

import exception.DukeException;
import exception.WrongEventDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class Event extends Task{
    protected String date;
    protected String firstTimeFrame;
    protected String secondTimeFrame;

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

    public String toString() {
        return taskCode() + super.toString() + " (by: " + stringToDate(date).format(DateTimeFormatter.ofPattern("MMM dd yyyy")) +
                " " + stringToTime(firstTimeFrame).format(DateTimeFormatter.ofPattern("hh:mm a")) +
                "-" + stringToTime(secondTimeFrame).format(DateTimeFormatter.ofPattern("hh:mm a")) + ")";
    }

    public String taskCode(){
        return "[E]";
    }

}
