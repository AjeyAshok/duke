package main.java;

import java.util.ArrayList;
import java.util.List;

public class Tasklist {
   // private static ui userI; //WHHY??
    ui ui = new ui();
    private static DateTimeParser dateTimer = new DateTimeParser();

    /**
     * Method to list out all the items in the list
     *
     * @param list arraylist containing all the tasks
     */
    public void lister(ArrayList<Task> list) {
        if(list.size() == 0)
            System.out.println("There are no tasks in the list");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }
    }

    /**
     * Method to mark a task as done
     *
     * @param point the index of the task where the necessary method needs to make a change
     * @param list arraylist containing all the tasks
     */
    public void donner(int point,ArrayList<Task> list ) {
        list.get(point).MarkAsDone(); //Changes the task marker
        System.out.println("Nice! I've marked this task as done:" + "\n" + list.get(point));
    }


    /**
     * Method to delete a task from the list
     *
     * @param point the index of the task where the necessary method needs to make a change
     * @param list arraylist containing all the tasks
     */
    public void deleter(int point, ArrayList<Task> list) {
        System.out.println("Noted. I've removed this task");
        System.out.println("   " + list.get(point));
        System.out.println("Now you have" + " " + (list.size() - 1) + " " + "task(s) in the list.");
        list.remove(point);
    }

    /**
     * Method to find all the task from the list which has all the tasks that has the given keyword
     *
     * @param list arraylist containing all the tasks
     * @param findertask
     */
    public void finder(ArrayList<Task> list, String findertask) {
        System.out.println("Here are the matching tasks in your list:");
        int count = 0;
        for(int i=0; i < list.size(); i++){
            if(list.get(i).getDescription().contains(findertask))
                System.out.println((++count) + ". " + list.get(i).toString());
        }
    }

    /**
     * Method to add a task with the deadline properties
     *
     * @param list arraylist containing all the tasks
     * @param Description the String that holds the description of the task
     * @param by the substring of user input that contains the details about dat and time
     * @throws DukeException when there is an issue in the format of the user input
     */
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

    /**
     * Method to add a task with the Event properties
     *
     * @param list arraylist containing all the tasks
     * @param Description the String that holds the description of the task
     * @param at the substring of the user input which contains the details of the date and time
     * @throws DukeException when there is an issue in the format of the user input
     */
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

    /**
     *
     * @param list arraylist containing all the tasks
     * @param Description the String that holds the description of the task
     * @throws DukeException when there is an issue in the format of the user input
     */
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
