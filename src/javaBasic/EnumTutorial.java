package javaBasic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class EnumTutorial {

    enum DaysOfTheWeek {
        SUNDAY(7, x-> System.out.println("SUNDAY is :" + x)),
        MONDAY(1, x-> System.out.println("MONDAY is :" + x)),
        TUESDAY(2, x-> System.out.println("TUESDAY is :" + x)),
        WEDNESDAY(3, x-> System.out.println("WEDNESDAY is :" + x)),
        THURSDAY(4, x-> System.out.println("THURSDAY is :" + x)),
        FRIDAY(5, x-> System.out.println("FRIDAY is :" + x)),
        SATURDAY(6, x-> System.out.println("SATURDAY is :" + x));

        //fields for each enum
        final int day;
        final Consumer<String> myFunc;

        private static final Map<Integer, DaysOfTheWeek> map;

        //static block will be called when the class is first loaded in memory
        static {
            map = new HashMap<>();
            Arrays.stream(DaysOfTheWeek.values())
                    .forEach(e -> map.put(Integer.valueOf(e.day), e));
        }

        DaysOfTheWeek(int day, Consumer<String> myFunc) {
            this.day = day;
            this.myFunc = myFunc;
        }

        public static DaysOfTheWeek getDayByKey(Integer key) {
            return map.get(key);
        }
    }

    public void client() {

        DaysOfTheWeek d = DaysOfTheWeek.getDayByKey(Integer.valueOf(2));

        System.out.println("day :" + d.name());
        switch (d) {
            case MONDAY:
                System.out.println("this is MONDAY");
                d.myFunc.accept("sad");
                break;
            case TUESDAY:
                System.out.println("this is TUESDAY");
                d.myFunc.accept("sad");
                break;
            case WEDNESDAY:
                System.out.println("this is WEDNESDAY");
                d.myFunc.accept("sad");
                break;
            case THURSDAY:
                System.out.println("this is THURSDAY");
                d.myFunc.accept("sad");
                break;
            case FRIDAY:
                System.out.println("this is FRIDAY");
                d.myFunc.accept("happy");
                break;
            case SATURDAY:
                System.out.println("this is SATURDAY");
                d.myFunc.accept("happy");
                break;
            case SUNDAY:
                System.out.println("this is SUNDAY");
                d.myFunc.accept("sad");
                break;
            default:
                System.out.println("out of the range");
                d.myFunc.accept("sad");
                break;
        }


    }

}
