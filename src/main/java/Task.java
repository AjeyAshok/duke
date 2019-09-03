package main.java;
import java.util.*;
public class Task {
    //    private String A;
    private String description;
    private boolean isDone;

    public Task(String A){
        this.description = A;
        this.isDone = false;
    }

    public boolean getisDone(){
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "[YES]" : "[NO]");
    }

    public void MarkAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return this.description;
    }

    public String toTxt() {
        return "";
    }
}