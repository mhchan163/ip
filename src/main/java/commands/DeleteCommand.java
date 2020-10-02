package commands;

import exception.DukeException;
import exception.EmptyInputException;
import storage.Storage;
import tasks.TaskList;

public class DeleteCommand extends Command {

        private final String text;

        public DeleteCommand(String text){
            this.text = text;
        }

        public void execute(TaskList list) throws DukeException,java.io.IOException {
            if(text.isBlank()){
                throw new EmptyInputException();
            } else {
                int index = Integer.parseInt(text);
                System.out.println("Noted. I've removed this task:" + System.lineSeparator() + list.tasklist.get(index - 1).toString());
                System.out.println("You now have " + (list.tasklist.size()-1) + " tasks in your list");
                list.tasklist.remove(index - 1);
            }
            Storage.saveListData(list);
        }
}

