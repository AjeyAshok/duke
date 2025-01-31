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
        return "[D]" + getStatusIcon() + " " + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toTxt() {
        return "D | " + (this.getisDone() ? "1" : "0") + " | " + this.getDescription() + " | " + this.by;
    }
}