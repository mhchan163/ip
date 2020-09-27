import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Storage {

    private File filePath;

    public Storage(){
        this.filePath = new File("C:/Users/Chan Meng Han/IdeaProjects/Duke/src/main/java/data/Duke.txt");
    }

    public ArrayList<Task> load() throws java.io.IOException{
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
}