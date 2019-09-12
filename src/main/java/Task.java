package main.java;
import java.util.*;
public class Task {


    protected Date DateNTime;
    private String description;
    private boolean isDone;

    /**
     * Takes input from user which is stored in the description string and given a status
     *
     * @param A is the user input
     */
    public Task(String A){
        this.description = A;
        this.isDone = false;
    }

    /**
     * Returns the status of the task
     *
     * @return status of task
     */
    public boolean getisDone(){
        return isDone;
    }

    /**
     * Returns ths description of the task
     *
     * @return description of task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Outputs the symbol for the task according to the isdone boolean
     *
     * @return the staus symbol
     */
    public String getStatusIcon() {
        return (isDone ? "[YES]" : "[NO]");
    }

    /**
     * Method to change the symbol of the task
     */
    public void MarkAsDone() {
        this.isDone = true;
    }

    /**
     * Returns the description of the task
     *
     * @return description of task
     */
    @Override
    public String toString() {
        return this.description;
    }

    /**
     * Creates a variable for text
     *
     * @return null
     */
    public String toTxt() {
        return "";
    }
}