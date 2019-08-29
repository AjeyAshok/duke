package main.java;
import java.util.*;

public class ToDo extends Task {

    protected String by;

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + getStatusIcon() + " " + super.toString();
    }
}
