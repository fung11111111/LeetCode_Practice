package javaBasic.oopConcept;

public class Abstraction {

    interface SendEmail{
        void sendEmail();
    }
    abstract class Work implements SendEmail {

        // no need to implement the interface, implemented by the subclass
        public abstract void sleep();
        public void saySomething() {};
        public void sayGoodBye() {};
    }

    public class Work1 extends Work {
        @Override
        public void sleep() {
            System.out.println("Sleep");
        }

        public void saySomething(){
            System.out.println("hello");
        }

        @Override
        public void sendEmail() {
            System.out.println("sent");
        }
    }
    public class Work2 extends Work {
        @Override
        public void sleep() {
            System.out.println("Sleep");
        }

        public void saySomething(){
            System.out.println("hi");
        }
        public void sayGoodBye() {
            System.out.println("bye");
        };

        @Override
        public void sendEmail() {
            System.out.println("sent");
        }
    }

    public void client(){
     //   Work a = new Work();
        //cannot instantiate the abstract class
        

        Work w = new Work1();
        Work w2 = new Work2();
        SendEmail s = new Work1();

        w.sayGoodBye();
        w.saySomething();
        w2.sayGoodBye();
        w2.saySomething();
        w2.sendEmail();
        s.sendEmail();

    }
}
