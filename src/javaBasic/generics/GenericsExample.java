package javaBasic.generics;

import java.util.ArrayList;
import java.util.List;

// a class help to perform different behavior according to the objects
// need to know what kind of objects will be processed
public class GenericsExample {

    //type param for generic class
    class Printer<T> {
        private T thingToPrint;

        public Printer(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public void print() {
            System.out.println(thingToPrint);
        }
    }

    class Transportation {
        private Double speed;

        public Transportation(Double speed) {
            this.speed = speed;
        }

        public Double getSpeed() {
            return speed;
        }

        public void printTransportation(){
            System.out.println("I am transportation");
        }
    }

    class Ship extends Transportation {
        public Ship(Double speed) {
            super(speed);
        }

        @Override
        public String toString() {
            return "Ship{" +
                    "speed=" + getSpeed() +
                    '}';
        }

        public void printMyself(){
            System.out.println("i am a ship");
        }
    }

    class Car extends Transportation {
        public Car(Double speed) {
            super(speed);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "speed=" + getSpeed() +
                    '}';
        }

        public void printMyself(){
            System.out.println("i am a ship");
        }
    }


    class PrinterForTransport<T extends Transportation> {
        T thingToPrint;

        public PrinterForTransport(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public void print() {
            System.out.println(thingToPrint.getSpeed());
            thingToPrint.printTransportation();
        }
    }

    public <T extends Transportation> String convertToGeneric(T a) {
        return "speed - " + a.getSpeed();
    }

    public void client() {
        Printer<Integer> p = new Printer<Integer>(23);
        p.print();

        Printer<String> p1 = new Printer<String>("23");
        p1.print();

        PrinterForTransport<Transportation> c = new PrinterForTransport<Transportation>(new Car(2.0));
        c.print();

        PrinterForTransport<Transportation> s = new PrinterForTransport<Transportation>(new Ship(3.0));
        s.print();


        shout("String");
        shout(123);
        shout(2.0);


        Car car = new Car(20.89);
        Ship ship = new Ship(30.0);

        System.out.println(convertToGeneric(car));
        System.out.println(convertToGeneric(ship));
        List<PrinterForTransport> eList = new ArrayList<>();
        eList.add(c);
        eList.add(s);
        printList(eList);

    }

    public static <T> void shout(T thingToShout) {
        System.out.println(thingToShout);
    }

    //wildcard
    public static void printList(List<? extends PrinterForTransport> thingToShouts) {
        thingToShouts.stream()
                .forEach( a -> a.print());
    }
}
