package main.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        // System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        int counter = 0;
        Scanner scan = new Scanner(System.in); //To include scanner to take in user input
        ArrayList<Task> list = new ArrayList<Task>(); //Creates an array of type Task
       // String test;

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
                System.out.println("Nice! I've marked this task as done:" + "\n" +
                        /*list.get(point).getStatusIcon() +*/ list.get(point));

            } else if (in[0].equals("deadline")) {
                String dead = s.substring(9);
                String[] newInput = dead.split("/by ");
                Task B = new Deadline(newInput[0], newInput[1]);
                list.add(B);
                System.out.println("Got it. I've added this task:");
                System.out.println("\t" + B);
                System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");

            } else if (in[0].equals("todo")) {
                String to = s.substring(5);
                //   String[] newInput1 = to.split(" ", 2);
                Task B1 = new ToDo(to);
                list.add(B1);
                System.out.println("Got it. I've added this task:");
                System.out.println("\t" + B1);
                System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");


            } else if(in[0].equals("event")) {
                String eve = s.substring(6);
                String[] newInput = eve.split("/at ");
                Task B2 = new Event(newInput[0], newInput[1]);
                list.add(B2);
                System.out.println("Got it. I've added this task:");
                System.out.println("\t" + B2);
                System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");


            } else {
                Task t = new Task(s);
                System.out.println("added: " + s);
                list.add(t);
            }
        }

    }
}

