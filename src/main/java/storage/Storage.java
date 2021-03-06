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

/**
 * Deals with storage related operations such as uploading tasks
 * from the save file and saving task into the save file.
 */
public class Storage {

    private final File filePath;

    public Storage(String filePath){
            this.filePath = new File(filePath);
    }

    /**
     * Loads the data from save file "Duke.txt" into the an ArrayList object
     * @return the ArrayList object with the save file data added
     * @throws java.io.IOException
     */
    public ArrayList<Task> load() throws java.io.IOException, DukeException {
            if(!filePath.exists()){
                createDirectory();
                filePath.createNewFile();
            }
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

    private static boolean createDirectory() throws java.io.IOException{
        File directory = new File("data");
        boolean isDirectory = false;
        if(!directory.exists()) {
            isDirectory = directory.mkdir();
        }
        return isDirectory;
    }

    /**
     * Writes the tasks inside the TaskList into the save file "Duke.txt"
     * @throws java.io.IOException
     */
    public static void saveListData(TaskList listData) throws java.io.IOException{
        FileWriter fw = new FileWriter("data/Duke.txt");
        for(Task t : listData.tasklist){
            fw.write(t.taskCode() + " | " + t.getStatusIcon()+ " | " + t.getDescription() + " | " + t.getDate() + " " +  t.getTime() + System.lineSeparator());
        }
        fw.close();
    }
}
