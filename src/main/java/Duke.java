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
        String[] list = new String[100];
        String line;
        for(int i=0;i<list.length;i++){
            line = in.nextLine();
            if(line.equals("bye")){
                break;
            } else if(line.equals("list")){
                System.out.println("____________________________________________________________");
                for(int j=0;j<i;j++) {
                    System.out.println(j + 1 + "." + list[j]);
                }
                System.out.println("____________________________________________________________");
            } else {
                list[i] = line;
                System.out.println("____________________________________________________________");
                System.out.println("Added: "+ line);
                System.out.println("____________________________________________________________");
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}

