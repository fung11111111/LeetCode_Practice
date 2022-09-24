package javaBasic;

public class Enum {

    enum DaysOfTheWeek{
        SUNDAY(7, false),
        MONDAY(1, true),
        TUESDAY(2, true),
        WEDNESDAY(3, true),
        THURSDAY(4, true),
        FRIDAY(5, true),
        SATURDAY(6, false);

        //fields for each enum
        final int day;
        final boolean isOnline;

        DaysOfTheWeek(int day, boolean isOnline) {
            this.day = day;
            this.isOnline = isOnline;
        }
    }

    public void client(){
        DaysOfTheWeek d = DaysOfTheWeek.SATURDAY;
        System.out.println(d.day);
        System.out.println(d.isOnline);

    }

}
