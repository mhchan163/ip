package commands;

import commands.Command;
import exception.DukeException;
import exception.EmptyInputException;
import tasks.Task;
import tasks.TaskList;

public class SearchCommand extends Command {
    public final String keyword;

    public SearchCommand(String text){
        keyword = text;
    }

    public void execute(TaskList list) throws DukeException {
        int count = 0;
        if(keyword.isBlank()){
            throw new EmptyInputException();
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("Here are the tasks with the key word: " + keyword);
            for(Task t : list.tasklist) {
                count++;
                if(t.getDescription().contains(keyword)){
                    System.out.println(count + "." + t.toString());
                }
            }
            System.out.println("____________________________________________________________");
        }
    }
}
