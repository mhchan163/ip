package commands;

import exception.DukeException;
import exception.EmptyInputException;
import exception.NoTimeInputException;
import tasks.Deadline;
import tasks.TaskList;
import storage.Storage;

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
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:" + System.lineSeparator() + list.tasklist.get(list.tasklist.size() - 1).toString());
                System.out.println("Now you have " + list.tasklist.size() + " tasks in your list.");
                System.out.println("____________________________________________________________");
                Storage.saveListData(list);
            }
        }
}

