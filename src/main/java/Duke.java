import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Duke {

    public static void printIntro(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) throws UnknownCommandException,EmptyInputException,java.io.IOException{
        printIntro();
        File f = new File("data/Duke.txt");
        if(f.exists()){
            //retrive saved file
            Scanner s = new Scanner(f);
        } else {
            f.createNewFile();
        }
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
        int count=0;
        String line;
        for(int i=0;i<list.length;i++) {
            try {
                line = in.nextLine();
                if (line.equals("bye")) {
                    break;
                } else if (line.equals("list")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Here are the tasks in your list:");
                    for (int j = 0; j < count; j++) {
                        System.out.println(j + 1 + "." + list[j].toString());
                    }
                    System.out.println("____________________________________________________________");
                } else if (line.startsWith("done")) {
                    String[] temp = line.split(" ");
                    int index = Integer.parseInt(temp[1]);
                    list[index - 1].markAsDone();
                    System.out.println("Nice! I've marked this as done:");
                    System.out.println(list[index - 1].toString());
                } else if (line.startsWith("todo")) {
                    list[count++] = new ToDo(line.substring(4));
                    if(list[count-1].description.isBlank()){
                        throw new EmptyInputException();
                    }
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task:" + System.lineSeparator() + list[count - 1].toString());
                    System.out.println("Now you have " + count + " tasks in your list.");
                    System.out.println("____________________________________________________________");
                } else if (line.startsWith("deadline")) {
                    if(line.substring(8).isBlank()){
                        throw new EmptyInputException();
                    }
                    String[] temp = line.split("/");
                    list[count++] = new Deadline(temp[0].substring(8), temp[1]);
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task:" + System.lineSeparator() + list[count - 1].toString());
                    System.out.println("Now you have " + count + " tasks in your list.");
                    System.out.println("____________________________________________________________");
                } else if (line.startsWith("event")) {
                    if(line.substring(5).isBlank()){
                        throw new EmptyInputException();
                    }
                    String[] temp = line.split("/");
                    list[count++] = new Event(temp[0].substring(5), temp[1]);
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task:" + System.lineSeparator() + list[count - 1].toString());
                    System.out.println("Now you have " + count + " tasks in your list.");
                    System.out.println("____________________________________________________________");
                } else {
                    throw new UnknownCommandException();
                }
            } catch(UnknownCommandException e) {
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("____________________________________________________________");
            } catch(EmptyInputException e) {
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! The description of a todo/deadline/event cannot be empty.");
                System.out.println("____________________________________________________________");
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}

