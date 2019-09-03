//package main.java;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

//public class Storage {
//
//    List<Task> tasks = new ArrayList<>();
//    File file = new File(System.getProperty("user.dir") + "/src/main/java/dukeDATA.txt");
//    SCanner scan = new Scanner(file);
//    while(scan.hasNext()) {
//        String[] line = scanner.nextline().split(" \\| ");
//        booolean stat = Integer.parseInt(line[1]) == 1;
//        if(line[0].equals("D")) {
//            tasks.add(new DukeDeadline(tasks, line));
//        } else if (line[0].equals("E")) {
//            tasks.add(new DukeEvent(tasks, line));
//        } else if (line[0].equals("T")) {
//            tasks.add(new DukeToDo(tasks, line));
//        }
//    }
//
//
//}
