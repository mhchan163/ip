package commands;

import ui.Ui;
import tasks.TaskList;
import storage.Storage;

public class ByeCommand extends Command {

    public void execute(TaskList list) throws java.io.IOException{
        Ui.printOutro();
        Storage.saveListData(list);
    }
}
