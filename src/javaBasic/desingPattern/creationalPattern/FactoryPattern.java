package javaBasic.desingPattern.creationalPattern;

public class FactoryPattern {
    abstract class Plan {
        double rate;

        abstract double getRate();

        public void calculateBill() {
            System.out.println("rate");
        }

    }

    class DomesticPlan extends Plan {

        @Override
        double getRate() {
            return 1.0;
        }
    }

    class ProfessionPlan extends Plan {

        @Override
        double getRate() {
            return 5.0;
        }
    }

    class GetPlanFactory {

        public Plan getPlanByType(String type) {
            if (type.equals("domestic")) {
                return new DomesticPlan();
            } else {
                return new ProfessionPlan();
            }
        }

    }


}
