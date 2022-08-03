package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamTest {

    class Adding {
        AtomicInteger num = new AtomicInteger(0);

        public void addNum() {
            num.incrementAndGet();
        }

        public int getNum() {
            return num.get();
        }


    }

    public void client() {
        List<Integer> list = Arrays.asList(1, 3, 3, 5, 6, 7, 21);
//        list.stream()
//                .forEach(System.out::println);

//        list.stream()
//                .filter(num -> num > 10)
//                .forEach(System.out::println);

//        System.out.println(list.stream()
//                .filter(num -> num > 10)
//                .reduce(i, Integer::sum
//                ));

//        list.stream().map(num -> num * 2)
//                .distinct()
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        Adding a = new Adding();
        list.parallelStream()
                .forEach(x -> {
                    a.addNum();
                });

        System.out.println(a.getNum());


    }
}
