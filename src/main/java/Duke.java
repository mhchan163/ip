import commands.ByeCommand;
import tasks.TaskList;
import storage.Storage;
import parser.Parser;
import commands.Command;
import exception.DukeException;
import exception.UnknownCommandException;
import exception.EmptyInputException;
import exception.NoTimeInputException;
import exception.WrongDeadlineDateFormatException;
import exception.WrongEventDateFormatException;
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
                Ui.printUnknownCommandMessage();
            } catch (EmptyInputException e) {
                Ui.printEmptyInputMessage();
            } catch (IndexOutOfBoundsException e) {
                Ui.printIndexOutOfBoundsMessage(list);
            } catch (NoTimeInputException e) {
                Ui.printNoTimeInputMessage();
            } catch (WrongDeadlineDateFormatException e){
                Ui.printWrongDeadlineDateFormatMessage();
            } catch (WrongEventDateFormatException e){
                Ui.printEventDateFormatMessage();
            }
        }
    }
}

