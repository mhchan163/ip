package commands;

import tasks.TaskList;

public class ListCommand extends Command {

    public void execute(TaskList list) {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int j = 0; j < list.tasklist.size(); j++) {
            System.out.println(j + 1 + "." + list.tasklist.get(j).toString());
        }
        System.out.println("____________________________________________________________");
    }
}

