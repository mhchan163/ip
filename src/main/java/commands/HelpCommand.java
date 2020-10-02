package commands;

import tasks.TaskList;
import ui.Ui;

public class HelpCommand extends Command {

    public void execute(TaskList list){
        Ui.printHelpMessage();
    }
}
