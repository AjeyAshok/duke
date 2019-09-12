package main.java;

public class parser {
    ui userI = new ui();
    protected String taskType; //Type of task : D,E,T
    protected String s; // User input
    protected String[] in; // User input after spliting at the " " space
    protected String Description;
    protected String findDes;
    protected String by;
    protected String at;
    protected String[] ToFrom;
    protected int point;

    /**
     * Takes in the user input and splits it into sub sections which are used by the individual task actions
     *
     * @param s the String that contains the user input
     */
    public parser(String s) {
        this.s = s;
        this.in = s.split(" "); //Delimtter function to split a string according to the parameter
        this.taskType = this.in[0];
        this.makeTask();
    }

    /**
     * Method which uses the user input to futrher make changes to the user input to be parsed into the tasklist class
     */
    public void makeTask() {
        if(this.taskType.equals("todo")) {
            this.Description = this.s.substring(4);

        } else if (this.taskType.equals("deadline")) {
            String dead = s.substring(9);
            String[] newInput = dead.split("/by ");
            this.by = newInput[1];
            this.Description = newInput[0];

        } else if (this.taskType.equals("event")) {
            String eve = s.substring(6);
            String[] newInput = eve.split("/at ");
            this.at = newInput[1];
            this.Description = newInput[0];

        } else if (this.taskType.equals("done")) {
            this.point = Integer.parseInt(in[1]) - 1;

        } else if (this.taskType.equals("find")) {
            this.findDes = in[1];

        } else if (this.taskType.equals("delete")) {
            this.point = Integer.parseInt(in[1]) - 1;

        }
    }

    /**
     * Returns the of type of task from the user input
     *
     * @return the type of task
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Returns the index of the task in the list
     *
     * @return index of task in list
     */
    public int getPoint() {
        return point;
    }

    /**
     * Returns the data stored in the by string
     *
     * @return data in by string
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns data stored in the at string
     *
     * @return data in the at string
     */
    public String getAt() {
        return at;
    }

    /**
     * Returns the tasks that the user is finding using the find function
     *
     * @return data with the keyword from user
     */
    public String getFindDes() {
        return findDes;
    }

    /**
     * Returns data stored in the string description
     *
     * @return data in the string description
     */
    public String getDescription() {
        return Description;
    }
}

