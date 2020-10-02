package ui;


import tasks.TaskList;

public class Ui {

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

    public static void printUnknownCommandMessage(){
        System.out.println("____________________________________________________________");
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        System.out.println("type \"help\" for a list of possible commands");
        System.out.println("____________________________________________________________");
    }

    public static void printEmptyInputMessage(){
        System.out.println("____________________________________________________________");
        System.out.println("OOPS!!! The description of a todo/deadline/event cannot be empty.");
        System.out.println("____________________________________________________________");
    }

    public static void printIndexOutOfBoundsMessage(TaskList list){
        System.out.println("____________________________________________________________");
        System.out.println("OOPS!!! You only have " + list.tasklist.size() + " tasks in your list.");
        System.out.println("____________________________________________________________");
    }

    public static void printInBetweenHorizontalLines(String message){
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }

    public static void printNoTimeInputMessage(){
        System.out.println("____________________________________________________________");
        System.out.println("OOPS!!! deadline/event commands require a time input." + System.lineSeparator() + "e.g [task] /[time]" );
        System.out.println("____________________________________________________________");
    }

    public static void printWrongDeadlineDateFormatMessage(){
        System.out.println("____________________________________________________________");
        System.out.println("OOPS!!! The date was written in an incorrect Format." + System.lineSeparator() + "Please follow the format given below: " +
                System.lineSeparator() + "/YYYY-MM-DD HHmm(24 hour format)");
        System.out.println("____________________________________________________________");
    }

    public static void printEventDateFormatMessage(){
        System.out.println("____________________________________________________________");
        System.out.println("OOPS!!! The date was written in an incorrect Format." + System.lineSeparator() + "Please follow the format given below: " +
                System.lineSeparator() + "/YYYY-MM-DD HHmm-HHmm(24 hour format)");
        System.out.println("____________________________________________________________");
    }

    public static void printTaskAddedMessage(TaskList list){
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:" + System.lineSeparator() + list.tasklist.get(list.tasklist.size() - 1).toString());
        System.out.println("Now you have " + list.tasklist.size() + " tasks in your list.");
        System.out.println("____________________________________________________________");
    }

    public static void printTaskDeletedMessage(TaskList list, int index){
        System.out.println("Noted. I've removed this task:" + System.lineSeparator() + list.tasklist.get(index - 1).toString());
        System.out.println("You now have " + (list.tasklist.size()-1) + " tasks in your list");
    }

    public static void printTaskDoneMessage(TaskList list, int index){
        list.tasklist.get(index - 1).markAsDone();
        System.out.println("Nice! I've marked this as done:");
        System.out.println(list.tasklist.get(index - 1).toString());
    }
    public static void printHelpMessage(){
        System.out.println("Here is the list of possible commands:"+ System.lineSeparator() + "todo" + System.lineSeparator() +
                "deadline" + System.lineSeparator() + "event" + System.lineSeparator() + "done" + System.lineSeparator() + "delete");
    }

}

