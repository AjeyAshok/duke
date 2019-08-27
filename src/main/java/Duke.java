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
        System.out.println(" Hello! I'm Duke\n" +
                "What can I do for you?");
        String s;
        int counter = 0;
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            s = in.nextLine();
            if (s.equals("list")) {
                Iterator itr = list.iterator();
                while (itr.hasNext())
                    System.out.println(itr.next());
            } else if(s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                counter++;
                System.out.println("added: " + s);
                list.add(counter + ". " + s);
            }
        }
    }
}

