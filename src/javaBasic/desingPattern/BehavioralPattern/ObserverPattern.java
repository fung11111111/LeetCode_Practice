package javaBasic.desingPattern.BehavioralPattern;


import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    interface Subject {
        public void register(Observer o);

        public void unRegister(Observer o);

        public void notifyObserver();
    }

    interface Observer {
        public void update(double applePrice, double googlePrice);
    }

    class StockGrabber implements Subject {

        private List<Observer> observerList;
        double aPrice;
        double gPrice;

        public StockGrabber() {
            this.observerList = new ArrayList<>();
        }

        @Override
        public void register(Observer o) {
            observerList.add(o);
        }

        @Override
        public void unRegister(Observer o) {
            observerList.remove(o);
            System.out.println("removed Observer");
        }

        @Override
        public void notifyObserver() {
            observerList.stream()
                    .forEach(o -> o.update(aPrice, gPrice));
        }

        public void setaPrice(double aPrice) {
            this.aPrice = aPrice;
            notifyObserver();
        }

        public void setgPrice(double gPrice) {
            this.gPrice = gPrice;
            notifyObserver();
        }

        }

    class StockObservers implements Observer{

        double aPrice;
        double gPrice;
        int id;
        Subject subject;

        public StockObservers(int id, Subject subject) {
            this.id = id;
            this.subject = subject;
            System.out.println("ObserverId " + id);
            subject.register(this);
        }

        @Override
        public void update(double applePrice, double googlePrice) {
            aPrice = applePrice;
            gPrice = googlePrice;
            System.out.println("price updated: " + applePrice + "/" + googlePrice);
        }

    }
    public void clientFunc(){
        StockGrabber subject = new StockGrabber();
        StockObservers o1 = new StockObservers(1, subject);

        subject.setaPrice(2.0);
        subject.setgPrice(3.0);
        StockObservers o2 = new StockObservers(2, subject);
        subject.setgPrice(8.0);

    }
}
