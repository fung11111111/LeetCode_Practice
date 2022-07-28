package desingPattern.BehavioralPattern;

public class ChainResponsibilityPattern {

    public interface Chain {

        public void setNextChain(Chain nextChain);

        public void calculate(Numbers request);
    }

    class Numbers {
        private int number1;
        private int number2;

        private String calculationWanted;

        public Numbers(int number1, int number2, String calculationWanted) {
            this.number1 = number1;
            this.number2 = number2;
            this.calculationWanted = calculationWanted;
        }

        public int getNumber1() {
            return number1;
        }

        public int getNumber2() {
            return number2;
        }

        public String getCalculationWanted() {
            return calculationWanted;
        }
    }

    class AddNumbers implements Chain {
        private Chain nextInChain;

        @Override
        public void setNextChain(Chain nextChain) {
            this.nextInChain = nextChain;
        }

        @Override
        public void calculate(Numbers request) {
            if (request.getCalculationWanted() == "add") {
                System.out.println("" + request.getNumber1() + " + " + request.getNumber2() + " = " + (request.getNumber2() + request.getNumber1()));
            } else {
                this.nextInChain.calculate(request);
            }
        }
    }

    class MinusNumber implements Chain {
        private Chain nextInChain;

        @Override
        public void setNextChain(Chain nextChain) {
            this.nextInChain = nextChain;
        }

        @Override
        public void calculate(Numbers request) {
            if (request.getCalculationWanted() == "minus") {
                System.out.println("" + request.getNumber2() + " - " + request.getNumber1() + " = " + (request.getNumber2() - request.getNumber1()));
            } else {
                nextInChain.calculate(request);
            }
        }
    }

    class Multiply implements Chain {
        private Chain nextInChain;

        @Override
        public void setNextChain(Chain nextChain) {
            this.nextInChain = nextChain;
        }

        @Override
        public void calculate(Numbers request) {
            if (request.getCalculationWanted() == "mul") {
                System.out.println("" + request.getNumber2() + " x " + request.getNumber1() + " = " + (request.getNumber2() * request.getNumber1()));
            } else {
                System.out.println("END of Chain");
            }
        }
    }

    public void client() {
        Chain c1 = new AddNumbers();
        Chain c2 = new MinusNumber();
        Chain c3 = new Multiply();

        c1.setNextChain(c2);
        c2.setNextChain(c3);

        c1.calculate(new Numbers(2, 2, "mul"));


    }
}
