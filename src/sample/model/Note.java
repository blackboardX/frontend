package sample.model;

import java.sql.Time;
import java.util.Date;

public class Note {
    private final int id;
    private Date date;
    private int count;
    private int time;

    public Note(int id, Date date, int count, int time) {
        this.id = id;
        this.date = date;
        this.count = count;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
