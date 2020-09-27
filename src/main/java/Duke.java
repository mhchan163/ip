import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class Duke {

    public static int count = 0;
    public static ArrayList<Task> list = new ArrayList<>();
    public static boolean isActive = true;

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

    public static void printOutro(){
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    public static void processInputCommand() throws UnknownCommandException,EmptyInputException,IndexOutOfBoundsException,NoTimeInputException{
        Scanner in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        if (line.equals("bye")) {
            isActive = false;
            return;
        } else if (line.equals("list")) {
            System.out.println("____________________________________________________________");
            System.out.println("Here are the tasks in your list:");
            for (int j = 0; j < list.size(); j++) {
                System.out.println(j + 1 + "." + list.get(j).toString());
            }
            System.out.println("____________________________________________________________");
        } else if(line.startsWith("help")){
            System.out.println("Here is the list of possible commands:"+ System.lineSeparator() + "todo" + System.lineSeparator() + "deadline" + System.lineSeparator() + "event" + System.lineSeparator() + "done" + System.lineSeparator() + "delete");
        } else if (line.startsWith("done")) {
            if(line.substring(4).isBlank()){
                throw new EmptyInputException();
            } else {
                String[] temp = line.split(" ");
                int index = Integer.parseInt(temp[1]);
                list.get(index - 1).markAsDone();
                System.out.println("Nice! I've marked this as done:");
                System.out.println(list.get(index - 1).toString());
            }
        } else if (line.startsWith("delete")) {
            if (line.substring(6).isBlank()) {
                throw new EmptyInputException();
            } else {
                String[] temp = line.split(" ");
                int index = Integer.parseInt(temp[1]);
                System.out.println("Noted. I've removed this task:" + System.lineSeparator() + list.get(index - 1).toString());
                list.remove(index - 1);
                count--;
            }
        } else if (line.startsWith("todo")) {
            if (line.substring(4).isBlank()) {
                throw new EmptyInputException();
            } else {
                list.add(new ToDo(line.substring(4)));
                count++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:" + System.lineSeparator() + list.get(count - 1).toString());
                System.out.println("Now you have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            }
        } else if (line.startsWith("deadline")) {
            if (line.substring(8).isBlank()) {
                throw new EmptyInputException();
            } else if(!line.contains("/")) {
                throw new NoTimeInputException();
            } else {
                String[] temp = line.split("/");
                list.add(new Deadline(temp[0].substring(8), temp[1]));
                count++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:" + System.lineSeparator() + list.get(count - 1).toString());
                System.out.println("Now you have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            }
        } else if (line.startsWith("event")) {
            if (line.substring(5).isBlank()) {
                throw new EmptyInputException();
            } else if(!line.contains("/")) {
                throw new NoTimeInputException();
            } else {
                String[] temp = line.split("/");
                list.add(new Event(temp[0].substring(5), temp[1]));
                count++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:" + System.lineSeparator() + list.get(count - 1).toString());
                System.out.println("Now you have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            }
        } else {
                throw new UnknownCommandException();
        }
    }

    public static void uploadSavedData() throws java.io.IOException{
        File f = new File("data/Duke.txt");
        if(f.exists()){
            Scanner s = new Scanner(f);
            while(s.hasNext()) {
                String[] input = s.nextLine().split("\\|");
                switch (input[0]) {
                    case "[T] ":
                        list.add(new ToDo(input[2]));
                        count++;
                        break;
                    case "[D] ":
                        list.add(new Deadline(input[2], input[3]));
                        count++;
                        break;
                    case "[E] ":
                        list.add(new Event(input[2], input[3]));
                        count++;
                        break;
                    default:
                }
                if (input[1].equals(" [V] ")) {
                    list.get(count - 1).markAsDone();
                }
            }
        } else {
            f.createNewFile();
        }
    }

    public static void saveListData() throws java.io.IOException{
        FileWriter fw = new FileWriter("C:/Users/Chan Meng Han/IdeaProjects/Duke/src/main/java/data/Duke.txt");
        for(Task t : list){
            fw.write(t.taskCode() + " | " + t.getStatusIcon()+ " | " + t.description + " | " + t.getTime() + System.lineSeparator());
        }
        fw.close();
    }

    public static void main(String[] args) throws java.io.IOException{
        printIntro();
        //uploadSavedData();
        Storage storage = new Storage();
        list = storage.load();
        while(isActive) {
            try {
                processInputCommand();
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
                System.out.println("OOPS!!! You only have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            } catch (NoTimeInputException e) {
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! deadline/event commands require a time input." + System.lineSeparator() + "e.g [task] /[time]" );
                System.out.println("____________________________________________________________");
            }
        }
        printOutro();
        saveListData();
    }
}

