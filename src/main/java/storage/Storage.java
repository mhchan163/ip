package storage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

import exception.DukeException;
import tasks.TaskList;
import tasks.Task;
import tasks.Deadline;
import tasks.Event;
import tasks.ToDo;

public class Storage {

    private final File filePath;

    public Storage(String filePath){
        this.filePath = new File(filePath);
    }


    public ArrayList<Task> load() throws java.io.IOException, DukeException {
            Scanner s = new Scanner(filePath);
            int count = 0;
            ArrayList<Task> tasklist = new ArrayList<>();
            while (s.hasNext()) {
                String[] input = s.nextLine().split("\\|");
                switch (input[0]) {
                    case "[T] ":
                        tasklist.add(new ToDo(input[2]));
                        count++;
                        break;
                    case "[D] ":
                        tasklist.add(new Deadline(input[2], input[3]));
                        count++;
                        break;
                    case "[E] ":
                        tasklist.add(new Event(input[2], input[3]));
                        count++;
                        break;
                    default:
                }
                if (input[1].equals(" [V] ")) {
                    tasklist.get(count - 1).markAsDone();
                }
            }
        return tasklist;
    }

    public static void saveListData(TaskList listData) throws java.io.IOException{
        FileWriter fw = new FileWriter("data/Duke.txt");
        for(Task t : listData.tasklist){
            fw.write(t.taskCode() + " | " + t.getStatusIcon()+ " | " + t.getDescription() + " | " + t.getDate() + " " +  t.getTime() + System.lineSeparator());
        }
        fw.close();
    }
}
