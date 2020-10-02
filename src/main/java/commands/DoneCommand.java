package commands;

import storage.Storage;
import tasks.TaskList;
import exception.DukeException;
import exception.EmptyInputException;


public class DoneCommand extends Command {
    private final String text;

    public DoneCommand(String text){
        this.text = text;
    }

    public void execute(TaskList list) throws DukeException , java.io.IOException {
        if(text.isBlank()){
            throw new EmptyInputException();
        } else {
            int index = Integer.parseInt(text);
            list.tasklist.get(index - 1).markAsDone();
            System.out.println("Nice! I've marked this as done:");
            System.out.println(list.tasklist.get(index - 1).toString());
        }
        Storage.saveListData(list);
    }
}
