package javaBasic;

import kotlin.Function;

import java.util.Optional;

public class OptionalClass {

    //optional is to tell user / developer the method or var can be null
    class Cat {
        private String name;
        private Integer age;

        public Cat(String name, Integer age) {
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

    public Cat findCatByName(String name) {
        return new Cat(name, 2);
    }

    public Optional<Cat> findCatByNameOptional(String name) {
        Cat c = new Cat(name, 3);
        return Optional.ofNullable(null);
    }

    public void client() {
        Cat c = findCatByName("Tom");
        System.out.println(c.getName());


        Optional<Cat> optionalCat = findCatByNameOptional("Tom");
        System.out.println(optionalCat.map(Cat::getAge)
                .orElse(1));


    }
}
