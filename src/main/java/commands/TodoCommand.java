package commands;

import exception.DukeException;
import exception.EmptyInputException;
import storage.Storage;
import tasks.ToDo;
import tasks.TaskList;

import java.io.IOException;

public class TodoCommand extends Command {

    private final String description;

    public TodoCommand(String text){
        description = text;
    }

    public void execute(TaskList list) throws DukeException, java.io.IOException {
        if (description.isBlank()) {
            throw new EmptyInputException();
        } else {
            list.tasklist.add(new ToDo(description));
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task:" + System.lineSeparator() + list.tasklist.get(list.tasklist.size()-1).toString());
            System.out.println("Now you have " + list.tasklist.size() + " tasks in your list.");
            System.out.println("____________________________________________________________");
            Storage.saveListData(list);
        }
    }
}
