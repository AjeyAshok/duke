package main.java;

import java.util.*;

public class Task {
    private String A;
    private boolean isDone;

    public Task(String A){
        this.A = A;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[YES]" : "[NO]");
    }

    public void MarkAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return this.A;
    }
}
