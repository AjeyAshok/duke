package main.java;

import java.util.ArrayList;
import java.util.List;

public class Tasklist {
   // private static ui userI; //WHHY??
    ui ui = new ui();
    private static DateTimeParser dateTimer = new DateTimeParser();

    public void lister(ArrayList<Task> list) {
        if(list.size() == 0)
            System.out.println("There are no tasks in the list");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }
    }

    public void donner(int point,ArrayList<Task> list ) {
        list.get(point).MarkAsDone(); //Changes the task marker
        System.out.println("Nice! I've marked this task as done:" + "\n" + list.get(point));
    }

    public void deleter(int point, ArrayList<Task> list) {
        System.out.println("Noted. I've removed this task");
        System.out.println("   " + list.get(point));
        System.out.println("Now you have" + " " + (list.size() - 1) + " " + "task(s) in the list.");
        list.remove(point);
    }

    public void finder(ArrayList<Task> list, String findertask) {
        System.out.println("Here are the matching tasks in your list:");
        int count = 0;
        for(int i=0; i < list.size(); i++){
            if(list.get(i).getDescription().contains(findertask))
                System.out.println((++count) + ". " + list.get(i).toString());
        }
    }

    public void DukeDeadline(ArrayList<Task> list, String Description, String by) throws DukeException {
        if (Description.equals("")) {
            throw new DukeException(ui.getWrongDeadline());
        }
        Task B = new Deadline(Description, by);
        DateTimeParser.DeadlineDT(by);
        list.add(B);
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + B);
        System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");
    }

    public  void DukeEvent(ArrayList<Task> list, String Description, String at) throws DukeException {

        if (Description.equals("")) {
            throw new DukeException(ui.getWrongEvent());
        }
        Task B2 = new Event(Description, at);
        DateTimeParser.EventDT(at);
        list.add(B2);
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + B2);
        System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");
    }

    public void DukeToDo(ArrayList<Task> list, String Description) throws DukeException {

        if (Description.equals("")) {
            throw new DukeException(ui.getWrongToDo());
        }
        Task B1 = new ToDo(Description);
        list.add(B1);
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + B1);
        System.out.println("Now you have" + " " + list.size() + " " + "tasks in the list.");
    }
}
