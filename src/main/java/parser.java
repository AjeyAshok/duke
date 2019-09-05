package main.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class parser {
    public ArrayList<Task> tasks;

    parser() {
        tasks = new ArrayList<Task>();
    }

    public void dataOUT() throws IOException {
        FileWriter fileW = new FileWriter(System.getProperty("user.dir") + "/src/main/java/dukeDATA.txt", false);
        for (Task tsk : tasks) {
            fileW.write(tsk.toTxt() + "\n");
        }
        fileW.close();
    }

    public ArrayList<Task> dataIN() throws FileNotFoundException, DukeException { //reader

        File file = new File(System.getProperty("user.dir") + "/src/main/java/dukeDATA.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) { //tester
            String[] line = scanner.nextLine().split("\\|");
            String type = line[0].trim();
            String status = line[1].trim();
            String des = line[2].trim();

            boolean stat = Integer.parseInt(status) == 1;
            switch (type) {
                case "D":
                    tasks.add(new Deadline(line[2], line[3]));
                    break;
                case "E":
                    tasks.add(new Event(line[2], line[3]));
                    break;
                case "T":
                    tasks.add(new ToDo(line[2]));
                    break;
            }
        }
        return tasks;
    }
}

