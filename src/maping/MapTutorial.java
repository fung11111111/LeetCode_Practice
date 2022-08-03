package maping;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTutorial {


    class User{
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
    //hashMap
    public void usingHashMap(){
        // hashCode return an integer values generated by a hashing algo
        //allows one null key and multiple null values
        //based in array data structure and hash table
        //O(1) performance in add remove and contains, faster than tree map
        // require more memory (contiguous region of memory)
        // can use initial capacity and load factor to tune performance
        // when to use? -> know how many items and no need extract item in order
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(4, "4");
        hashMap.put(2, "2");
        hashMap.put(5, "5");
        hashMap.put(6, "3");
        hashMap.keySet().stream()
                .forEach(k -> System.out.println(hashMap.get(k)));


        //hashCode
        // Objects has equal hashCode if they are equal

        //can override hashCode method to compare different objects
        //e.g.
//        @Override
//        public int hashCode() {
//            return (int) id * name.hashCode() * email.hashCode();
//        }

    }


    //treeMap
    public void usingTreeMap(){
        //O(log n) performance
        // based on red black tree
        // less memory required
        // more cost on keeping the tree balance
        // not allow null key
        // when to use ? not know how many items and need ordering in key
        Map<User, String> treeMap = new TreeMap<>((k1,k2) -> {
            return k2.getAge() - k1.getAge();
        });
        treeMap.put(new User("Ray", 10), "1");
        treeMap.put(new User("Tommy", 40), "4");
        treeMap.put(new User("Betty", 21), "2");
        treeMap.put(new User("Tim", 30), "5");
        treeMap.put(new User("Tom", 11), "3");
        treeMap.keySet().stream()
                .forEach(k -> System.out.println(k.getName()));
    }
}