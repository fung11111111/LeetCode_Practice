package desingPattern.structuralPattern;

public class CompositePattern {

    public interface Employee{
        String getName();
        String getDep();
    }

    public class Accountant implements Employee{
        String name = "Mary";
        String dep = "Accountant";


        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDep() {
            return dep;
        }
    }

    public class Cashier implements Employee{
        String name = "Bob";
        String dep = "Cashier";
        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDep() {
            return dep;
        }
    }

}
