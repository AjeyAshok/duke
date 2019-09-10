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

    public parser(String s) {
        this.s = s;
        this.in = s.split(" "); //Delimtter function to split a string according to the parameter
        this.taskType = this.in[0];
        this.makeTask();
    }

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
            int point = Integer.parseInt(in[1]) - 1;

        } else if (this.taskType.equals("find")) {
            this.findDes = in[1];

        } else if (this.taskType.equals("delete")) {
            this.point = Integer.parseInt(in[1]) - 1;

        }
    }

    public String getTaskType() {
        return taskType;
    }

    public int getPoint() {
        return point;
    }

    public String getBy() {
        return by;
    }

    public String getAt() {
        return at;
    }

    public String getFindDes() {
        return findDes;
    }

    public String[] getTiming() {
        return ToFrom;
    }

    public String getDescription() {
        return Description;
    }
}

