package main.java;

import java.util.*;
public class Deadline extends Task {

    protected String by;

    /**
     * Takes in the data from the user
     *
     * @param description is String that contains the description of the task
     * @param by is String that contains the date and time of the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the status, description, date and time of the task in the given format
     *
     * @return String in given format
     */
    @Override
    public String toString() {
        String temp = "";
        try {
            temp = "[D]" + getStatusIcon() + " " + super.toString() + " (by: " +  DateTimeParser.DeadlineDT(by) + ")";
        } catch (DukeException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Returns status, description, date and time to the text file
     *
     * @return formatted string for text file
     */
    @Override
    public String toTxt() {
        return "D | " + (this.getisDone() ? "1" : "0") + " | " + this.getDescription() + " | " + this.by;
    }

    /**
     * Sets the correct format for the date and time
     *
     * @param DateNTime formatted date and time for deadline task
     */
    public void setDateAndTime(Date DateNTime) {
        this.DateNTime = DateNTime;
    }
}