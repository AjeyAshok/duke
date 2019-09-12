package main.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;



public class Duke {
    private static ArrayList<Task> list = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    private static DateTimeParser dateTimer = new DateTimeParser();

    /**
     * Runs the main class to activate DUKE
     * Initialises the storage,tasklist, ui of the system
     *
     */

    public static void main(String[] args) throws IOException, DukeException {
        storage data_handler = new storage();
        Tasklist tasklist = new Tasklist();
        ui ui = new ui();
        ui.StartMsg();
        list = data_handler.dataIN(); //open file and write all the new changes

        /**
         * Takes in the command given by the user and runs the relevant code to get the output in a loop
         *
         */

        while (true) {
            String s = scan.nextLine(); //Takes in the input by user
            parser parser = new parser(s);
            String command = parser.getTaskType();

            if (command.equals("bye")) {
                ui.EndMsg();
                break;
            } else if (command.equals("list")) {
                tasklist.lister(list);
            } else if (command.equals("done")) {
                tasklist.donner(parser.getPoint(), list);
            } else if (command.equals("delete")) {
                tasklist.deleter(parser.getPoint(), list);
                System.out.println("point =" + parser.getPoint());
            } else if (command.equals("find")) {
                tasklist.finder(list, parser.getFindDes());
            } else if (command.equals("todo")) {
                tasklist.DukeToDo(list, parser.getDescription());
            } else if (command.equals("deadline")) {
                tasklist.DukeDeadline(list, parser.getDescription(), parser.getBy());
            } else if (command.equals("event")) {
                tasklist.DukeEvent(list, parser.getDescription(), parser.getAt());
            } else {
                throw new DukeException(ui.getWrongInput());
            }

            data_handler.dataOUT(); // close file
        }
        scan.close();
    }

    /**
     * Shows the error message when the program catches an exception
     *
     * @param m is the message that is written in by the developer for the exception
     */
    private static void DukeHandleException(DukeException m) {
        System.out.println(m.getMessage());
    }
}


