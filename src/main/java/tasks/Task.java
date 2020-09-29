package tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String taskCode(){
        return "";
    }

    public String getDescription() {
        return description;
    }

    public String getTime(){
        //returns nothing here cause there is no time component
        return "";
    }

    public String getDate(){
        return "";
    }

    public String getStatusIcon() {
        return (isDone ? "[V]" : "[X]"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        return getStatusIcon() +  description;
    }


}


