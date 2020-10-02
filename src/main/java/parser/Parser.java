package parser;

import commands.DeadlineCommand;
import exception.DukeException;
import exception.UnknownCommandException;
import commands.Command;
import commands.ByeCommand;
import commands.SearchCommand;
import commands.DeleteCommand;
import commands.DoneCommand;
import commands.EventCommand;
import commands.TodoCommand;
import commands.HelpCommand;
import commands.ListCommand;


public class Parser {

    public static Command parseCommand(String userInput) throws DukeException{
        String[] words = userInput.trim().split(" ", 2);

        final String command = words[0];
        final String text = userInput.replaceFirst(command, "").trim();

        switch (command) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "done":
                return new DoneCommand(text);
            case "delete":
                return new DeleteCommand(text);
            case "help":
                return new HelpCommand();
            case "todo":
                return new TodoCommand(text);
            case "deadline":
                return new DeadlineCommand(text);
            case "event":
                return new EventCommand(text);
            case "search":
                return new SearchCommand(text);
            default:
                throw new UnknownCommandException();

        }
    }
}
