package tasks;

/**
 * This class creates an ArrayList of type Task
 * to store the input tasks from the user.
 */

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
