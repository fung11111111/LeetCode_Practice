package javaBasic.desingPattern.BehavioralPattern;

public class StrategyPattern {

    //strategy pattern vs state pattern
    //strategy pattern: having a different implementation to accomplish same goal
    //state pattern: ding different things based on the state

    interface Strategy {
        public void calculation(int a, int b);
    }

    class Add implements Strategy{

        @Override
        public void calculation(int a, int b) {
            System.out.println(a + b);
        }
    }

    class Minus implements  Strategy{

        @Override
        public void calculation(int a, int b) {
            System.out.println(b - a );
        }
    }

    class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void executeStrategy(int a, int b){
            strategy.calculation(a,b);
        }
    }

    public void client(){
        Context c = new Context(new Add());
        c.executeStrategy(2,3);
    }
}
