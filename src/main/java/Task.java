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

    public String getTime(){
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


