import java.util.GregorianCalendar;

class MyDate {
    
     int year;
     int month;
     int day;

    public MyDate() {
        this(System.currentTimeMillis());
    }

     MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

     MyDate(int year, int month, int day) {
        year = year;
        month = month;
        day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        
        GregorianCalendar calendar = new GregorianCalendar();
        
        calendar.setTimeInMillis(elapsedTime);
        
        year = calendar.get(GregorianCalendar.YEAR);
        
        month = calendar.get(GregorianCalendar.MONTH);
        
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
}

public class Main {
    
    public static void main(String[] args) {
        
        MyDate date1 = new MyDate();
        System.out.println("First Date: Year is " + date1.getYear() + ", Month is " + date1.getMonth() + ", Day is " + date1.getDay());
        
        MyDate date2 = new MyDate(34355555133101L);
        System.out.println("Second Date: Year is " + date2.getYear() + ", Month is " + date2.getMonth() + ", Day is " + date2.getDay());
    }
}
