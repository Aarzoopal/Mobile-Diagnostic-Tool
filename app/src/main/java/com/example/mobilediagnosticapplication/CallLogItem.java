package com.example.mobilediagnosticapplication;

public class CallLogItem {

    private String name;
    private String number;
    private int type;
    private long date;
    private long duration;

    public CallLogItem(String name, String number, int type, long date, long duration) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.date = date;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }

    public long getDate() {
        return date;
    }

    public long getDuration() {
        return duration;
    }

}
