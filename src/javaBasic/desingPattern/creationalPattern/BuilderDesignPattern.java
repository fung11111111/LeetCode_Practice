package javaBasic.desingPattern.creationalPattern;

import java.util.ArrayList;
import java.util.List;

public class BuilderDesignPattern {

    interface Packing {
        String pack();

        int price();
    }

    abstract class CD implements Packing {
        public abstract String pack();
    }

    abstract class Company extends CD {
        public abstract int price();
    }


    public class Sony extends Company {

        @Override
        public String pack() {
            return "Sony";
        }

        @Override
        public int price() {
            return 20;
        }
    }

    public class Apple extends Company {
        @Override
        public String pack() {
            return "apple";
        }

        @Override
        public int price() {
            return 30;
        }
    }

    class CDType {
        private List<Packing> packings = new ArrayList<>();
        public void addItems(Packing p){
            packings.add(p);
        }
        public void showItems(){
            packings.stream()
                    .forEach(item -> System.out.println(item.pack() + " " + item.price()));
        }
    }

    class CDBuilder{
        public CDType buildSony(){
           CDType cds =new CDType();
            cds.addItems(new Sony());
            return cds;
        }
        public CDType buildApple(){
            CDType cds =new CDType();
            cds.addItems(new Apple());
            return cds;
        }

    }

    public void executeSth(){
        CDBuilder c1 = new CDBuilder();
        CDType ctype = c1.buildApple();
        ctype.showItems();
    }
}
