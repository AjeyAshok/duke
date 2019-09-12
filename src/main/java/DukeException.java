package main.java;

public class DukeException extends Exception {
    /**
     * Outputs the message when an exception is caught by the program
     *
     * @param message message given by the developer
     */
    public DukeException(String message){
        super(message);
    }
}
