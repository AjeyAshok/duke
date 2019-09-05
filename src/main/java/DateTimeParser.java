package main.java;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeParser {

    public static String DeadlineDT(String by) throws DukeException {
        //Take in the input as dd/mm/year time
        String[] input = by.split(" ", 2); //split the date from time
        if(input.length != 2) {
            throw new DukeException("     OOPS! Wrong input format for deadline. Follow this format 01/01/2000 1500");
        }
        input[0] = input[0].trim(); //clear the empty space from date
        input[1] = input[1].trim(); //clear the empty space from time

        String[] date = input[0].split("/");

        int day,month,year,time;
        try {
            //Separate the day, month,yr and time
            day = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[2]);
            time = Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new DukeException("     OOPS! Wrong input format for deadline. Follow this format 01/01/2000 1500");
        }

        if(time < 0 || time > 2400) {
            throw new DukeException("     OOPS! Wrong input format for deadline. Follow this format 01/01/2000 1500");
        }

        if(validDT(day,month,year)) {
            return DateIN(day,month,year) + ", " + TimeIN(time);
        } else {
            throw new DukeException("     OOPS! Wrong input format for deadline. Follow this format 01/01/2000 1500");
        }
    }

    public static String EventDT(String by) throws DukeException {
        //Take in the input as dd/mm/year time
        String[] input = by.split(" ", 2); //split the date from time
        if(input.length != 2) {
            throw new DukeException("     OOPS! Wrong format for EVENT. Please key in /at 1/1/2019 1500-1600");
        }
        input[0] = input[0].trim(); //clear the empty space from date
        input[1] = input[1].trim(); //clear the empty space from time

        String[] date = input[0].split("/");
        if(date.length != 3) throw new DukeException("     OOPS! Wrong format for EVENT. Please key in /at 1/1/2019 1500-1600");

        int day,month,year,Stime, Etime;
        try {
            //Separate the day, month,yr and time
            day = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[2]);
            String[] timeTotime = input[1].split("-"); //Spliting the start and end time
            Stime = Integer.parseInt(timeTotime[0]);
            Etime = Integer.parseInt(timeTotime[1]);
        } catch (NumberFormatException e) {
            throw new DukeException("     OOPS! Wrong format for EVENT. Please key in /at 1/1/2019 1500-1600");
        }

        if(Stime < 0 || Stime > 2400 || Etime < 0 || Etime > 2400) {
            throw new DukeException("     OOPS! Wrong format for EVENT. Please key in /at 1/1/2019 1500-1600");
        }

        if(validDT(day,month,year)) {
            return DateIN(day,month,year) + ", " + TimeIN(Stime) +  " - " +  TimeIN(Etime);
        } else {
            throw new DukeException("     OOPS! Wrong format for EVENT. Please key in /at 1/1/2019 1500-1600");
        }
    }

    private static boolean checkLeapyr(int year) {
        if((year%4 == 0 && year%100 == 0) || year%400 == 0) {
            return true;
        }
        return false;
    }

    private static boolean validDT(int d, int m, int y) {

        if(d<1 || d>31 || m<1 || m>12 || y<0)
            return false;

        if(m==2) {
            if(checkLeapyr(y)) {
                if(d>29)
                    return false;
            } else {
                if(d>28)
                    return false;
            }
        } else if (m==4 || m==6 || m==9 || m==11) {
            if(d>30)
                return false;
        }
        return true;
    }

    private static String DateIN (int d, int m, int y) {
        String Fdate = "";
        int lastD = d%10;

        if(lastD == 1)      Fdate += d +"st of ";
        else if(lastD == 2) Fdate += d + "nd of ";
        else if(lastD == 3) Fdate += d + "rd of ";
        else                Fdate += d + "th of ";

        if(m==1)
            Fdate += "January";
        else if(m==2)
            Fdate += "February";
        else if(m==3)
            Fdate += "March";
        else if(m==4)
            Fdate += "April";
        else if(m==5)
            Fdate += "May";
        else if(m==6)
            Fdate += "June";
        else if(m==7)
            Fdate += "July";
        else if(m==8)
            Fdate += "August";
        else if(m==9)
            Fdate += "September";
        else if(m==10)
            Fdate += "October";
        else if(m==11)
            Fdate += "November";
        else if(m==12)
            Fdate += "December";

        Fdate += " " + y;

        return Fdate;
    }

    private static String TimeIN(int t) throws DukeException {
        String tout;
        int hr, mins;
        if (t == 2400) t = 0000;
        hr = t / 100;
        mins = t % 100;

        if (hr > 12) {
            hr -= 12;
            tout = "pm";
        } else if (hr == 12)
            tout = "pm";
          else
              tout = "am";

        if(hr == 0) hr = 12;

        if(mins == 0) return hr + "" + tout;
        else if(mins < 10) return hr + ":0" + mins +tout;
        else if(mins < 60) return hr + ":" + mins + tout;
        else throw new DukeException("     OOPS! Invalid time entered");
    }

}
