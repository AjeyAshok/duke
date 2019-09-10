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

    public String getLogo() {
        return logo;
    }

    public void StartMsg() {
        System.out.println(logo + "\n" + "Hello! I'm Duke\n" + "What can I do for you?");
    }

    public void EndMsg() {
        System.out.println(" Bye. Hope to see you again soon!\n");
    }

    public String getWrongInput() {
        return WrongInput;
    }

    public String getWrongEvent() {
        return WrongEvent;
    }

    public String getWrongDeadline() {
        return WrongDeadline;
    }

    public String getWrongToDo() {
        return WrongToDo;
    }

    public void addedTask() {
        System.out.println("Got it. I've added this todo: \n ");
    }

    public String getWrongDelete() {
        return WrongDelete;
    }

    public String getWrongFind() {
        return WrongFind;
    }

    public void findTask() {
        System.out.println("Here are the matching tasks in your list:\n");
    }

    public String getWrongDnT() {
        return WrongDnT;
    }

    public String getWrongDone() {
        return WrongDone;
    }

//    public static void TaskDone() {
//        System.out.println("Noted! I've marked this todo as done: \n");
//    }

    public void byeUser() {
        System.out.println(" Bye. Hope to see you again soon!\n");
    }

}
