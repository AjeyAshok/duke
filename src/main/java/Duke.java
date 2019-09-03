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
    public static void main(String[] args) throws IOException {
        parser data_handler = new parser();
        list = data_handler.dataIN();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        // System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        while (true) {
            String s = scan.nextLine(); //Takes in the input by user
            String[] in = s.split(" "); //Delimtter function to split a string according to the parameter

            if (s.equals("list")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + "." + list.get(i));
                }
            } else if (s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;

            } else if (in[0].equals("done")) {
                int point = Integer.parseInt(in[1]) - 1; //parseInt changes a string to int
                list.get(point).MarkAsDone(); //Changes the task marker
                System.out.println("Nice! I've marked this task as done:" + "\n" + list.get(point));

            } else if (in[0].equals("delete")) {
                int remover = Integer.parseInt(in[1]) - 1;
                list.remove(remover);
                System.out.println("Noted. I've removed this task");
                System.out.println(list.get(remover));
                System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");

            } else if (in[0].equals("deadline")) {
                try {
                    DukeDeadline(list, s);
                } catch (DukeException m) {
                    DukeHandleException(m);
                }
                data_handler.dataOUT();

            } else if (in[0].equals("todo")) {
                try {
                    DukeToDo(list, s);
                } catch (DukeException m) {
                    DukeHandleException(m);
                }
                data_handler.dataOUT();

            } else if (in[0].equals("event")) {
                try {
                    DukeEvent(list, s);
                } catch (DukeException m) {
                    DukeHandleException(m);
                }
                data_handler.dataOUT();

            } else {
                DukeHandleException(new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-("));
            }
        }
    }

    private static void DukeDeadline(List<Task> list, String s) throws DukeException {
        String dead = s.substring(9);
        String[] newInput = dead.split("/by ");
        if (newInput[1].equals("")) {
            throw new DukeException("    ☹ OOPS!!! You need to add the due date for the deadline!");
        }
        Task B = new Deadline(newInput[0], newInput[1]);
        list.add(B);
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + B);
        System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");
    }

    private static void DukeEvent(List<Task> list, String s) throws DukeException {
        String eve = s.substring(6);
        String[] newInput = eve.split("/at ");
        if (newInput[1].equals("")) {
            throw new DukeException("    ☹ OOPS!!! You need to add the timing for the event!");
        }
        Task B2 = new Event(newInput[0], newInput[1]);
        list.add(B2);
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + B2);
        System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");
    }

    private static void DukeToDo(List<Task> list, String s) throws DukeException {
        String to = s.substring(4);
        if (to.equals("")) {
            throw new DukeException("    ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        Task B1 = new ToDo(to);
        list.add(B1);
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + B1);
        System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");
    }

    private static void DukeHandleException(DukeException m) {
        System.out.println(m.getMessage());
    }
}