package javaBasic.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    }

    class PrinterForTransport <T extends Transportation>{
        T thingToPrint;

        public PrinterForTransport(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public void print() {
          System.out.println(thingToPrint.getSpeed());
        }
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

        List<Car> cars = new ArrayList<>();
        printList(cars);
        List<Ship> ships = new ArrayList<>();
        printList(ships);
    }

    public static <T> void shout(T thingToShout){
        System.out.println(thingToShout);
    }

    //wildcard
    public static void printList(List<? extends Transportation> thingToShout){
        System.out.println(thingToShout);
    }
}
