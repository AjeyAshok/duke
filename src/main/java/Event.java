package main.java;
import java.util.*;

public class Event extends Task {
    protected String at;
    protected String start;
    protected String end;


    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

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

    @Override
    public String toTxt() {
        return "E | " + (this.getisDone() ? "1" : "0") + " | " + super.getDescription() + " | " + this.at;
    }
}