package app;

public class Time implements Comparable<Time>{
    private final int hour;
    private final int minutes;

    public Time(){
        this(0,0);
    }

    public Time(String time){
        String[] timeArray = time.split(":");
        this.hour          = Integer.parseInt(timeArray[0]);
        this.minutes       = Integer.parseInt(timeArray[1]);
    }

    public Time(int hour, int minutes){
        this.hour    = hour;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Time other) {
        if (hour != other.hour)
            return hour - other.hour;
        return minutes - other.minutes;
    }

    public static int compareTimes(Time first, Time second){
        if (first.hour != second.hour)
            return first.hour - second.hour;
        return first.minutes - second.minutes;
    }

    public boolean equals(Object obj){
        if(obj instanceof Time){
            Time other = (Time) obj;
            return hour == other.hour && minutes == other.minutes;
        }
        return false;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public String toCSVFormat(){
        return String.format("%02d:%02d", hour, minutes);
    }

    public String toString() {
        return String.format("Time(hh:mm) : %02d:%02d", hour, minutes);
    }
}
