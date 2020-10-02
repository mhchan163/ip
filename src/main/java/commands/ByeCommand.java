package commands;

import ui.Ui;
import tasks.TaskList;

public class ByeCommand extends Command {

    public void execute(TaskList list){
        Ui.printOutro();
    }
}
