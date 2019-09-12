package main.java;
import java.util.*;

public class ToDo extends Task {

    protected String by;

    /**
     * Takes in the data from the user
     *
     * @param description is String that contains the description of the task
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the status, description, date and time of the task in the given format
     *
     * @return String in given format
     */
    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + " " + super.toString();
    }

    /**
     * Returns status, description, date and time to the text file
     *
     * @return formatted string for text file
     */
    @Override
    public String toTxt() {
        return "T | " + (this.getisDone() ? "1" : "0") + " | " + this.getDescription();
    }
}

