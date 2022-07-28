package oopConcept;

public class Polymorphism {

    interface test {
        static String getName() {
            return "x";
        }
    }

    class Bird {
        public void sound() {
            System.out.println("Bird");
        }
    }

    class Robin extends Bird {
        public void work() {

        }

        public void work(String n) {

        }

        public void work(String n, int a) {

        }
    }

    public void client() {
        Bird b = new Robin();
        b.sound();
    }
}
