/**
 * Deadline is a type of task that involves a time input in addition to
 * the string description.
 */
public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
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
        return "[D]";
    }


}
