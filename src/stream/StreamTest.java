package stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    class Employee {
        private String name;
        private String gender;
        private Integer age;

        public Employee(String name, String gender, Integer age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public void client() {
        List<Employee> employees = List.of(new Employee("Tom", "M", 20), new Employee("Marry", "F", 30), new Employee("May", "F", 31), new Employee("David", "M", 22));


        //filter
        System.out.println("Filtering");
        employees.stream()
                .filter(employee -> employee.getGender().equals("M"))
                .forEach(System.out::println);

        //sort
        System.out.println("Sorting");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .forEach(System.out::println);
        //all match, anymatch, nonematch
        System.out.println("all match");
        System.out.println(employees.stream().allMatch(employee -> employee.getAge() > 18));
        System.out.println("any match");
        System.out.println(employees.stream().anyMatch(employee -> employee.getAge() > 30));
        System.out.println("none match");
        System.out.println(employees.stream().noneMatch(employee -> employee.getAge() > 40));

        //max
        System.out.println("with max age");
        employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);
        //min
        employees.stream()
                .min(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);

        //group
        System.out.println("grouping by");
        Map<String, List<Employee>> employeeMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        employeeMap.forEach((g, e) -> {
            System.out.println(g);
            e.forEach(System.out::println);
            System.out.println();
        });


        System.out.println("AtomicInteger");
        AtomicInteger totalAge = new AtomicInteger(0);
        employees.parallelStream()
                .forEach(employee -> totalAge.addAndGet(employee.getAge()));
        System.out.println(totalAge);






    }
}
