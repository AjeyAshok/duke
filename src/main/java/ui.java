package main.java;

public class ui {

    protected String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    protected String WrongInput = " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    protected String WrongEvent = "☹ OOPS!!! The description of an event cannot be empty.\n" +
            "ENTER IN THE FOLLOWING FORMAT : event dance /at 23/12/2019 1700-1800\n";
    protected String WrongToDo = "☹ OOPS!!! The description of a todo cannot be empty.\n" +
            "ENTER IN THE FOLLOWING FORMAT : todo return book ";
    protected String WrongDeadline = "☹ OOPS!!! The description of a deadline cannot be empty.\n" +
            "ENTER IN THE FOLLOWING FORMAT : deadline run /by 5/9/2019 2000\n";
    protected String WrongDnT = "ENTER IN THE FOLLOWING FORMAT : d/M/y HHmm\n";
    protected String WrongDone = "CHOOSE A TASK TO MARK AS DONE : done <number>\n";
    protected String WrongDelete = "EITHER LIST IS EMPTY OR YOUR ENTRY FORMAT IS WRONG \n" +
            "ENTER IN THE FOLLOWING FORMAT : delete <number>";
    protected String WrongFind = "EITHER THE TASK SEARCHED DOESN'T EXIST OR ENTRY FORMAT IS WRONG \n" +
            "ENTER IN THE FOLLOWING FORMAT : find book\n";

    /**
     * Returns the logo of the DUKE
     *
     * @return logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Prints the message when the program is ran
     */
    public void StartMsg() {
        System.out.println(logo + "\n" + "Hello! I'm Duke\n" + "What can I do for you?");
    }

    /**
     * Prints message when user inputs command bye
     */
    public void EndMsg() {
        System.out.println(" Bye. Hope to see you again soon!\n");
    }

    /**
     * Statement when a wrong user input is detected
     *
     * @return error message for wrong user input
     */

    public String getWrongInput() {
        return WrongInput;
    }

    /**
     * Statement when a wrong user input for event task is detected
     *
     * @return error message for wrong event task input
     */
    public String getWrongEvent() {
        return WrongEvent;
    }

    /**
     * Statement when a wrong user in input for deadline task is detected
     *
     * @return error message for wrong deadline task input
     */
    public String getWrongDeadline() {
        return WrongDeadline;
    }

    /**
     * Statement when a wrong user input for todo task is detected
     *
     * @return error message for wrong todo task input
     */
    public String getWrongToDo() {
        return WrongToDo;
    }

    /**
     * Output statement when a task is added to the list
     */
    public void addedTask() {
        System.out.println("Got it. I've added this todo: \n ");
    }

    /**
     * Statement when a wrong user input for delete task is detected
     *
     * @return error message for wrong delete task input
     */
    public String getWrongDelete() {
        return WrongDelete;
    }

    /**
     * Statement when a wrong user input for the find task is detected
     *
     * @return wrror message for the wrong find task input
     */
    public String getWrongFind() {
        return WrongFind;
    }

    /**
     * Output statement when tasks are found using the keyword given by the user
     */
    public void findTask() {
        System.out.println("Here are the matching tasks in your list:\n");
    }

    /**
     * Statement when wrong user input for the date and time for tasks are detected
     *
     * @return error messgae for wrong date and tme format
     */
    public String getWrongDnT() {
        return WrongDnT;
    }

    /**
     * Statement when a wrong user in put for the done task is detected
     *
     * @return error message for the wrong done task
     */
    public String getWrongDone() {
        return WrongDone;
    }
}
