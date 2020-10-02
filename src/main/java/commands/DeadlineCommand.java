package commands;

import exception.DukeException;
import exception.EmptyInputException;
import exception.NoTimeInputException;
import storage.Storage;
import tasks.Deadline;
import tasks.TaskList;
import ui.Ui;

/**
 * This class creates a new deadline task when executed. Data is
 * saved after the task is added.
 */
public class DeadlineCommand extends Command {
    private final String description;

    public DeadlineCommand(String text) {
        description = text;
    }

    public void execute(TaskList list) throws DukeException, java.io.IOException {
        if (description.isBlank()) {
            throw new EmptyInputException();
        } else if (!description.contains("/")) {
            throw new NoTimeInputException();
        } else {
            String[] temp = description.split("/");
            list.tasklist.add(new Deadline(temp[0], temp[1]));
            Ui.printTaskAddedMessage(list);
            Storage.saveListData(list);
        }
    }
}


