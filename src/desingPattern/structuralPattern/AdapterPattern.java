package desingPattern.structuralPattern;

import java.util.concurrent.Callable;

public class AdapterPattern {

    interface CreditCard{
        public void giveBankDetails();
        public String getCreditCard();
    }

    class BankDetail{
        String name;
        String holderName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }
    }

    public class Customer extends BankDetail implements CreditCard{

        public void adaptor(){
            setHolderName("Hello");
            setName("ICIC");

            giveBankDetails();
            System.out.println(getCreditCard());

        }
        @Override
        public void giveBankDetails() {
            System.out.println(getName());

        }

        @Override
        public String getCreditCard() {
            return "123";
        }
    }
}
