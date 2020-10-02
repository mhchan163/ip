
package commands;

import tasks.TaskList;
import exception.DukeException;

public abstract class Command {

    public abstract void execute(TaskList tasks) throws DukeException,java.io.IOException;
}