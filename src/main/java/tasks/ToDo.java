package tasks;

public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString(){
        return taskCode() + super.toString();
    }

    @Override
    public String taskCode(){
        return "[T]";
    }



}
