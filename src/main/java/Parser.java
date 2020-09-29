/**
 * Deals with the user input command by checking if it
 * corresponds to available commands.
 */
public class Parser {

    /**
     * Splits up the given user input into the command
     * and the task description and calls the method
     * depending on the command input.
     * @param userInput
     * @throws DukeException
     */
    public void parseCommand(String userInput) throws DukeException{
        String[] words = userInput.trim().split(" ", 2);

        final String command = words[0];
        final String text = userInput.replaceFirst(command, "").trim();

        switch (command) {
            case "bye":
                Duke.list.ByeCommand();
                break;
            case "list":
                Duke.list.ListCommand();
                break;
            case "done":
                Duke.list.DoneCommand(text);
                break;
            case "delete":
                Duke.list.DeleteCommand(text);
                break;
            case "help":
                Duke.list.HelpCommand();
                break;
            case "todo":
                Duke.list.ToDoCommand(text);
                break;
            case "deadline":
                Duke.list.DeadlineCommand(text);
                break;
            case "event":
                Duke.list.EventCommand(text);
                break;
            default:
                throw new UnknownCommandException();

        }
    }
}
