package main.java;

import java.util.*;
public class Deadline extends Task {

    protected String by;


    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

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

    @Override
    public String toTxt() {
        return "D | " + (this.getisDone() ? "1" : "0") + " | " + this.getDescription() + " | " + this.by;
    }

    public void setDateAndTime(Date DateNTime) {
        this.DateNTime = DateNTime;
    }
}