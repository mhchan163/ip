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
    public String toString() {
        return taskCode() + super.toString() + " (by: " + by + ")";
    }

    public String taskCode(){
        return "[D]";
    }


}
