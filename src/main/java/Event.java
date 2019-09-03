package main.java;
import java.util.*;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + " " + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String toTxt() {
        return "E | " + (this.getisDone() ? "1" : "0") + " | " + super.getDescription() + " | " + this.at;
    }
}