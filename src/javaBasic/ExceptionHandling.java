package javaBasic;

public class ExceptionHandling {

    class Student{
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void throwNullPointer(){

        Student s = null;
        try{
            System.out.println(s.getName());
            int array[] = new int[2];
            array[3] = 10;

        }catch (NullPointerException e) {
            System.out.println("Exception thrown  :" + e);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e);
        }


    }
}
