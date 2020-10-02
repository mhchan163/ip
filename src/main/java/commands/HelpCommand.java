package commands;

import tasks.TaskList;
import ui.Ui;

/**
 * This class prints out a help message when executed.
 */
public class HelpCommand extends Command {

    public void execute(TaskList list){
        Ui.printHelpMessage();
    }
}
