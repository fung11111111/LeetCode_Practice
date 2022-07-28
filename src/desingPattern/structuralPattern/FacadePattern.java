package desingPattern.structuralPattern;

import java.util.Arrays;
import java.util.List;

public class FacadePattern {
    interface MobileShop {
        void printPrice();
    }

    class Iphone implements MobileShop {

        @Override
        public void printPrice() {
            System.out.println("iphone 28");
        }
    }

    class SamSung implements MobileShop {

        @Override
        public void printPrice() {
            System.out.println("SamSung 18");
        }
    }

    class ShopKeeper{
        List<MobileShop> shops = Arrays.asList(new Iphone(), new SamSung());

        void displayinfo(){
            shops.stream().forEach(MobileShop::printPrice);
        }

    }

    public void testPrint(){
        ShopKeeper s = new ShopKeeper();
        s.displayinfo();
    }
}
