
package commands;
/**
 * the command class consists of the different possible commands
 * that the user can input, and excutes the given command.
 */

import tasks.TaskList;
import exception.DukeException;

public abstract class Command {

    public abstract void execute(TaskList tasks) throws DukeException,java.io.IOException;
}