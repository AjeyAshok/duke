package main.java;
import java.util.*;

public class Event extends Task {
    protected String at;
    protected String start;
    protected String end;

    /**
     * Takes in the data from the user
     *
     * @param description is String that contains the description of the task
     * @param by is String that contains the date and time of the task
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
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
            return "[E]" + getStatusIcon() + " " + super.toString() + " (at: " + DateTimeParser.EventDT(at) + ")";
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
        return "E | " + (this.getisDone() ? "1" : "0") + " | " + super.getDescription() + " | " + this.at;
    }
}