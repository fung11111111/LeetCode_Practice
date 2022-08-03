package javaBasic.desingPattern.BehavioralPattern;

public class StatePattern {

    interface Connection{
        public void open();
        public void close();
        public void update();
    }

    class Accounting implements Connection{

        @Override
        public void open() {
            System.out.println("Open for accounting");
        }

        @Override
        public void close() {
            System.out.println("Close for accounting");
        }

        @Override
        public void update() {
            System.out.println("Update for accounting");
        }
    }

    class Sales implements Connection{

        @Override
        public void open() {
            System.out.println("Open for Sales");
        }

        @Override
        public void close() {
            System.out.println("Close for Sales");
        }

        @Override
        public void update() {
            System.out.println("Update for Sales");
        }
    }

    class Controller{
        public Accounting ac;
        public Sales sales;
        private Connection connection;

        public Controller() {
            this.ac = new Accounting();
            this.sales = new Sales();
        }

        public void setAccountingConnection(){
            connection = ac;
        }

        public void setSalesConnection(){
            connection = sales;
        }

        public void open(){
            connection.open();
        }
        public void close(){
            connection.close();
        }
        public void update(){
            connection.update();
        }
    }

    public void client(String state){
        Controller controller = new Controller();
        if(state.equals("sales")){
            controller.setSalesConnection();
        }else {
            controller.setAccountingConnection();
        }

        controller.open();
        controller.close();
    }
}
