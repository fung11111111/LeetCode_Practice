package javaBasic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualHashCode {

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

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Student student = (Student) o;
//            return Objects.equals(name, student.name);
//        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public void client(){
        Map<Student,String> map = new HashMap<>();
        Student s1 = new Student("Tom");
        Student s3 = new Student("Tom");
        Student s2 =s1;

        map.put(s1, "Tom");
        map.put(s2, "Tommy");

        String a = "abc";
        String b = "abc";


        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(map.size());
        System.out.println(map.get(s2));
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());







    }
}
