/**
 * Creates an ArrayList of type Task to store Task objects and
 * handles the various operations such as add,delete,list,exit,
 * and done.
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

    public void ByeCommand(){
        Duke.isActive = false;
        return;
    }
    public void ListCommand(){
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int j = 0; j < tasklist.size(); j++) {
            System.out.println(j + 1 + "." + tasklist.get(j).toString());
        }
        System.out.println("____________________________________________________________");
    }

    public void DoneCommand(String text) throws DukeException{
        if(text.isBlank()){
            throw new EmptyInputException();
        } else {
            int index = Integer.parseInt(text);
            tasklist.get(index - 1).markAsDone();
            System.out.println("Nice! I've marked this as done:");
            System.out.println(tasklist.get(index - 1).toString());
        }

    }

    public void DeleteCommand(String text) throws DukeException{
        if (text.isBlank()) {
            throw new EmptyInputException();
        } else {
            int index = Integer.parseInt(text);
            System.out.println("Noted. I've removed this task:" + System.lineSeparator() + tasklist.get(index - 1).toString());
            tasklist.remove(index - 1);
        }
    }

    public void HelpCommand(){
        System.out.println("Here is the list of possible commands:"+ System.lineSeparator() + "todo" + System.lineSeparator() + "deadline" + System.lineSeparator() + "event" + System.lineSeparator() + "done" + System.lineSeparator() + "delete");
    }

    public void ToDoCommand(String text) throws DukeException{
        if (text.isBlank()) {
            throw new EmptyInputException();
        } else {
            tasklist.add(new ToDo(text));
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task:" + System.lineSeparator() + tasklist.get(tasklist.size()-1).toString());
            System.out.println("Now you have " + tasklist.size() + " tasks in your list.");
            System.out.println("____________________________________________________________");
        }
    }

    public void DeadlineCommand(String text) throws DukeException {
        if (text.isBlank()) {
            throw new EmptyInputException();
        } else if(!text.contains("/")) {
            throw new NoTimeInputException();
        } else {
            String[] temp = text.split("/");
            tasklist.add(new Deadline(temp[0], temp[1]));
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task:" + System.lineSeparator() + tasklist.get(tasklist.size() - 1).toString());
            System.out.println("Now you have " + tasklist.size() + " tasks in your list.");
            System.out.println("____________________________________________________________");
        }
    }

    public void EventCommand(String text) throws DukeException{
        if (text.isBlank()) {
            throw new EmptyInputException();
        } else if(!text.contains("/")) {
            throw new NoTimeInputException();
        } else {
            String[] temp = text.split("/");
            tasklist.add(new Event(temp[0], temp[1]));
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task:" + System.lineSeparator() + tasklist.get(tasklist.size() - 1).toString());
            System.out.println("Now you have " + tasklist.size() + " tasks in your list.");
            System.out.println("____________________________________________________________");
        }
    }


    public void SearchCommand(String text) throws DukeException{
        int count = 0;
        if(text.isBlank()){
            throw new EmptyInputException();
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("Here are the tasks with the key word: " + text);
            for(Task t : tasklist) {
                count++;
                if(t.description.contains(text)){
                    System.out.println(count + "." + t.toString());
                }
            }
            System.out.println("____________________________________________________________");
        }
    }
}
