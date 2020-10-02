package commands;

import exception.DukeException;
import exception.EmptyInputException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

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
                Ui.printTaskDeletedMessage(list,index);
                list.tasklist.remove(index - 1);
            }
            Storage.saveListData(list);
        }
}

