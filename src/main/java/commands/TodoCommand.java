package commands;

import exception.DukeException;
import exception.EmptyInputException;
import storage.Storage;
import tasks.ToDo;
import tasks.TaskList;
import ui.Ui;

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
            Ui.printTaskAddedMessage(list);
            Storage.saveListData(list);
        }
    }
}
