import commands.ByeCommand;
import tasks.TaskList;
import storage.Storage;
import parser.Parser;
import commands.Command;
import exception.DukeException;
import exception.UnknownCommandException;
import exception.EmptyInputException;
import exception.NoTimeInputException;
import tasks.WrongDateFormatException;
import ui.Ui;
import java.io.IOException;
import java.util.Scanner;

public class Duke {

    public static TaskList list;
    public static boolean isActive = true;


    public static void main(String[] args) throws IOException,DukeException{
        Ui.printIntro();
        Storage storage = new Storage("data/Duke.txt");
        list = new TaskList(storage.load());
        while(isActive) {
            try {
                Scanner in = new Scanner(System.in);
                Command command = Parser.parseCommand(in.nextLine());
                command.execute(list);
                if (command instanceof ByeCommand){
                   isActive = false;
                }
            } catch (UnknownCommandException e) {
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("type \"help\" for a list of possible commands");
                System.out.println("____________________________________________________________");
            } catch (EmptyInputException e) {
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! The description of a todo/deadline/event cannot be empty.");
                System.out.println("____________________________________________________________");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! You only have " + list.tasklist.size() + " tasks in your list.");
                System.out.println("____________________________________________________________");
            } catch (NoTimeInputException e) {
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! deadline/event commands require a time input." + System.lineSeparator() + "e.g [task] /[time]" );
                System.out.println("____________________________________________________________");
            } catch (WrongDateFormatException e){
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! The date was written in an incorrect Format." + System.lineSeparator() + "Please follow the format given below: " +
                        System.lineSeparator() + "/YYYY-MM-DD HHmm(24 hour format)");
                System.out.println("____________________________________________________________");
            }
        }
        Ui.printOutro();
        storage.saveListData(list);
    }
}

