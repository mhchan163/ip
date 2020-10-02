package tasks;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> tasklist;

    public TaskList(){
        tasklist = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList){
        tasklist = taskList;
    }

}
