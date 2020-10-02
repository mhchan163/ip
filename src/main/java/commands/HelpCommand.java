package commands;

import tasks.TaskList;

public class HelpCommand extends Command {

    public void execute(TaskList list){
        System.out.println("Here is the list of possible commands:"+ System.lineSeparator() + "todo" + System.lineSeparator() + "deadline" + System.lineSeparator() + "event" + System.lineSeparator() + "done" + System.lineSeparator() + "delete");
    }
}
