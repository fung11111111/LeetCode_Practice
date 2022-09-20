package javaBasic;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInter {

    @FunctionalInterface
    interface Read {
        void readBook();
    }

    class Student implements Read {

        @Override
        public void readBook() {
            System.out.println("hello world book");
        }


    }

    public void print(Read r) {
        r.readBook();
    }

    public void printWithSupplier(Supplier<String> s) {
        System.out.println(s.get());
    }

    public void printWithConsumer(Consumer c, Read r){
        c.accept(r);
    }

    public void client() {
        // define the readBook function;
        // can only have one abstract function
        // can only the action itself / implementation
        // best practice to add @FunctionalInterface to limit the abstract methods
        Read r = () -> System.out.println("hello world book");
        print(r);

        Function<String, String> quote = s -> "'" + s + "'";
        System.out.println(quote.apply("hello"));

        //lazy generation
        //doest not take any arguments
        Supplier<String> sup = () -> "hey";
        printWithSupplier(sup);

        //accept arguments but not return
        Consumer<Read> con = (j) -> {
            j.readBook();
        };
        printWithConsumer(con, r);





    }
}
