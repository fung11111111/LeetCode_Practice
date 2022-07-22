package desingPattern.creationalPattern;

public class AbstractFactoryPattern {

    // Abstract Factory is to have a class contain different type of factory
    //Factory is to a class create similar objects
    interface Bank {
        String getBankName();
    }

    class HDFC implements Bank {
        private String name;

        HDFC() {
            this.name = "HDFC";
        }

        @Override
        public String getBankName() {
            return name;
        }
    }

    class ICIC implements Bank {
        private String name;

        public ICIC() {
            this.name = "ICIC";
        }

        @Override
        public String getBankName() {
            return name;
        }
    }

    abstract class Loan {
        double rate;

        abstract double getRate();
    }

    class FamilyLoan extends Loan {

        @Override
        double getRate() {
            return 1.0;
        }
    }

    class StudentLoan extends Loan {

        @Override
        double getRate() {
            return 3.0;
        }
    }

    abstract class AbstractFactory {
        abstract Bank getBankByName(String name);

        abstract Loan getLoanByName(String name);
    }

    class BankFactory extends AbstractFactory {

        @Override
        Bank getBankByName(String name) {
            if (name.equals("ICIC")) {
                return new ICIC();
            } else return new HDFC();
        }

        @Override
        Loan getLoanByName(String name) {
            return null;
        }
    }

    class LoanFactory extends AbstractFactory {

        @Override
        Bank getBankByName(String name) {
            return null;
        }

        @Override
        Loan getLoanByName(String name) {
            if (name == "family") {
                return new FamilyLoan();
            } else return new StudentLoan();
        }
    }

    class FactoryCreator{
        public AbstractFactory getFactory(String name){
            if(name.equals("Bank")){
                return new BankFactory();
            }else return new LoanFactory();
        }
    }


}
