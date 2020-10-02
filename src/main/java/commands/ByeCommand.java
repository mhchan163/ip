package commands;

import ui.Ui;
import tasks.TaskList;
import storage.Storage;

/**
 * The ByeCommand exits the program when executed, and
 * saves the list data before the exit.
 */
public class ByeCommand extends Command {

    public void execute(TaskList list) throws java.io.IOException{
        Ui.printOutro();
        Storage.saveListData(list);
    }
}
