package javaBasic.desingPattern.structuralPattern;

public class DecoratorPattern {

    interface Food{
        String getFoodName();
    }

    class VegFood implements Food{

        @Override
        public String getFoodName() {
            return "VegFood";
        }
    }

    abstract class FoodDecorator implements Food{
        Food food;

        public FoodDecorator(Food food) {
            this.food = food;
        }

        public String getFoodName() {
            return food.getFoodName();
        }
    }

    class FastFood extends FoodDecorator{

        public FastFood(Food food) {
            super(food);
        }

        public String getFoodName(){
            return "fastFood";
        }
    }

    public void testFunc(){
        Food f = new VegFood();
        System.out.println(f.getFoodName());

        Food fastFood = new FastFood(f);
        System.out.println(fastFood.getFoodName());
    }
}
