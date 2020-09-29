/**
 * Event is a type of task that includes a time input in addition to
 * the string description.
 */
public class Event extends Task{
    protected String by;

    public Event(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getTime(){
        return by;
    }

    @Override
    /**
     *Returns the taskCode, description, date and time of the task combined into a string
     *@param none
     *@return String
     */
    public String toString() {
        return taskCode() + super.toString() + " (by: " + by + ")";
    }

    public String taskCode(){
        return "[E]";
    }

}
