package javaBasic;

import java.util.Optional;

public class OptionalTutorial {

    class Car {
        private String modal;
        private double price;

        public Car(String modal, double price) {
            this.modal = modal;
            this.price = price;
        }

        public String getModal() {
            return modal;
        }

        public void setModal(String modal) {
            this.modal = modal;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public void client() {
        Car c = new Car("BMW", 12.5);

        Optional<Car> car = Optional.of(c);
        Optional<Car> car2 = Optional.ofNullable(null);
        String a = car.map(Car::getModal).get();
        System.out.println("my car is : " + car.map(Car::getModal).get());
        car2.ifPresent(c2 -> {
            System.out.println(c2.getModal());
            System.out.println(c2.getPrice());
        });
        if (car.isPresent()) {
            System.out.println(car.map(Car::getModal));
            System.out.println(car.map(Car::getPrice));
        }

    }
}
