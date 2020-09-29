package parser;

import exception.DukeException;
import exception.UnknownCommandException;
import tasks.TaskList;

public class Parser {

    public void parseCommand(String userInput, TaskList listData) throws DukeException{
        String[] words = userInput.trim().split(" ", 2);

        final String command = words[0];
        final String text = userInput.replaceFirst(command, "").trim();

        switch (command) {
            case "bye":
                listData.ByeCommand();
                break;
            case "list":
                listData.ListCommand();
                break;
            case "done":
                listData.DoneCommand(text);
                break;
            case "delete":
                listData.DeleteCommand(text);
                break;
            case "help":
                listData.HelpCommand();
                break;
            case "todo":
                listData.ToDoCommand(text);
                break;
            case "deadline":
                listData.DeadlineCommand(text);
                break;
            case "event":
                listData.EventCommand(text);
                break;
            case "search":
                listData.SearchCommand(text);
                break;
            default:
                throw new UnknownCommandException();

        }
    }
}
