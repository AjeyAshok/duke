package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class storage {
    public ArrayList<Task> tasks;



    storage() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Loads the file when program re-runs
     * @throws IOException
     */
    public void dataOUT() throws IOException {
        FileWriter fileW = new FileWriter(System.getProperty("user.dir") + "/src/main/java/dukeDATA.txt", false);
        for (Task tsk : tasks) {
            fileW.write(tsk.toTxt() + "\n");
        }
        fileW.close();
    }

    /**
     * Takes in the new data given by user and updates the file
     *
     * @return tasks the final set of tasks in the list after all the alterations
     * @throws FileNotFoundException when the file location is unclear
     * @throws DukeException when there is an issue with writing the data in the file
     */

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
