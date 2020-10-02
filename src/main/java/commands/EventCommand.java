package commands;

import exception.DukeException;
import exception.EmptyInputException;
import exception.NoTimeInputException;
import tasks.Deadline;
import tasks.TaskList;
import storage.Storage;
import ui.Ui;

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
                list.tasklist.add(new Deadline(temp[0], temp[1]));
                Ui.printTaskAddedMessage(list);
                Storage.saveListData(list);
            }
        }
}

