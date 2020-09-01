import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
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
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
        int count=0;
        String line;
        for(int i=0;i<list.length;i++) {
            line = in.nextLine();
            if (line.equals("bye")) {
                break;
            } else if (line.equals("list")) {
                System.out.println("____________________________________________________________");
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < count; j++) {
                    System.out.println(j + 1 + "." +list[j].toString());
                }
                System.out.println("____________________________________________________________");
            } else if (line.contains("done")) {
                String[] temp = line.split(" ");
                int index = Integer.parseInt(temp[1]);
                list[index - 1].markAsDone();
                System.out.println("Nice! I've marked this as done:");
                System.out.println(list[index - 1].toString());
            } else if(line.contains("todo")) {
                list[count++] = new ToDo(line.substring(4));
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:"+System.lineSeparator()+list[count-1].toString());
                System.out.println("Now you have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            } else if(line.contains("deadline")){
                String[] temp = line.split("/");
                list[count++] = new Deadline(temp[0].substring(8),temp[1]);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:" +System.lineSeparator()+list[count-1].toString());
                System.out.println("Now you have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            } else if(line.contains("event")){
                String[] temp = line.split("/");
                list[count++] = new Event(temp[0].substring(5),temp[1]);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:" +System.lineSeparator()+list[count-1].toString());
                System.out.println("Now you have " + count + " tasks in your list.");
                System.out.println("____________________________________________________________");
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}

