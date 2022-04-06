package app;


public class Date implements Comparable<Date>{
    private final int   day;
    private final Month month;
    private final int   year;

    public Date(){
        this(0, null, 0);
    }

    public Date(String date){
        String[] dateArray = date.split("-");
        this.day     = Integer.parseInt(dateArray[0]);
        this.month   = Month.valueOf(dateArray[1].toUpperCase());
        this.year    = Integer.parseInt(dateArray[2]);
    }

    public Date(int day, Month month, int year) {
        this.day    = day;
        this.month  = month;
        this.year   = year;
    }

    @Override
    public int compareTo(Date other) {
        if(!month.equals(other.month))
            return month.compareTo(other.month);
        else if (day != other.day)
            return day - other.day;
        return year - other.year;
    }

   public static int compareDates(Date first, Date second) {
       if(!first.month.equals(second.month))
           return first.month.compareTo(second.month);
       else if (first.day != second.day)
           return first.day - second.day;
       return first.year - second.year;
    }

    public boolean equals(Object obj){
        if(obj instanceof Date){
            Date other   = (Date) obj;
            return  day  == other.day   &&
                    year == other.year &&
                    month.equals(other.month);
        }
            return false;
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toCSVFormat(){
        return String.format("%02d",day) + "-" + month + "-" + String.format("%02d",year);
    }

    public String toString() {
        return "Launch Date [day-month-year]: " + this.toCSVFormat();
    }
}
