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
        Scanner in = new Scanner(System.in); //To include scanner to take in user input
        ArrayList<Task> list = new ArrayList<Task>(); //Creates an array of type Task
        while (true) {
            String s = in.nextLine(); //Takes in the input by user
            String[] Doned = s.split(" "); //Delimtter function to split a string according to the parameter

            if (s.equals("list")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + "." + list.get(i).getStatusIcon() + list.get(i));
                }
            } else if (s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (Doned[0].equals("done")) {
                int point = Integer.parseInt(Doned[1]) -1; //parseInt changes a string to int
                list.get(point).MarkAsDone(); //Changes the task marker
                System.out.println("Nice! I've marked this task as done:" + "\n" +
                        list.get(point).getStatusIcon() + list.get(point));
            } else {
                Task t = new Task(s);
                System.out.println("added: " + s);
                list.add(t);
            }
        }

    }
}

