package tasks;

/**
 * A basic type of Task the has a string description.
 */
public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
    }

    @Override
    /**
     *Returns the taskCode and description of the task combined into a string
     *@param none
     *@return String
     */
    public String toString(){
        return taskCode() + super.toString();
    }

    @Override
    public String taskCode(){
        return "[T]";
    }



}
