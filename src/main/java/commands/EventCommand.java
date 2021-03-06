package commands;

import exception.DukeException;
import exception.EmptyInputException;
import exception.NoTimeInputException;
import tasks.TaskList;
import tasks.Event;
import storage.Storage;
import ui.Ui;

/**
 * This class creates a new event task when executed. Data is
 * saved after the task is added.
 */
public class EventCommand extends Command {
        private final String description;

        public EventCommand(String text){
            description = text;
        }

        public void execute(TaskList list) throws DukeException,java.io.IOException {
            if (description.isBlank()) {
                throw new EmptyInputException();
            } else if(!description.contains("/")) {
                throw new NoTimeInputException();
            } else {
                String[] temp = description.split("/");
                list.tasklist.add(new Event(temp[0], temp[1]));
                Ui.printTaskAddedMessage(list);
                Storage.saveListData(list);
            }
        }
}

