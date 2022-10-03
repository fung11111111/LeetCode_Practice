package javaBasic.desingPattern.creationalPattern;

import java.util.Optional;

public class BuilderPattern2 {
    //create a complex object step by step
    // e.g. a complex object many contains many fields and need to init the constructor with many params

    class Car {
        private String name;
        private String color;
        private Double speed;
        private String brand;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", speed=" + speed +
                    ", brand='" + brand + '\'' +
                    '}';
        }
    }

    class CarSchema {
        private String name;
        private String color;
        private String brand;
        private Boolean isManual;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Boolean getManual() {
            return isManual;
        }

        public void setManual(Boolean manual) {
            isManual = manual;
        }

        @Override
        public String toString() {
            return "CarSchema{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", brand='" + brand + '\'' +
                    ", isManual=" + isManual +
                    '}';
        }
    }

    interface Builder {
        Builder reset();

        Builder setName(String name);

        Builder setColor(String color);

        Builder setBrand(String brand);


    }

    class CarBuilder implements Builder {
        private Car car;

        public CarBuilder() {
            this.car = new Car();
        }

        @Override
        public Builder reset() {
            this.car = new Car();
            return this;
        }

        @Override
        public Builder setName(String name) {
            this.car.setName(name);
            return this;
        }

        @Override
        public Builder setColor(String color) {
            this.car.setColor(color);
            return this;
        }

        @Override
        public Builder setBrand(String brand) {
            this.car.setBrand(brand);
            return this;
        }

        public Builder setSpeed(Double speed) {
            this.car.setSpeed(speed);
            return this;
        }

        public Car getProduct() {
            return this.car;
        }
    }

    class CarSchemaBuilder implements Builder {
        private CarSchema carSchema;

        public CarSchemaBuilder() {
            this.carSchema = new CarSchema();
        }

        @Override
        public Builder reset() {
            this.carSchema = new CarSchema();
            return this;
        }

        @Override
        public Builder setName(String name) {
            this.carSchema.setName(name);
            return this;
        }

        @Override
        public Builder setColor(String color) {
            this.carSchema.setColor(color);
            return this;
        }

        @Override
        public Builder setBrand(String brand) {
            this.carSchema.setBrand(brand);
            return this;
        }

        public Builder setIsManual(Boolean isManual) {
            this.carSchema.setManual(isManual);
            return this;
        }

        public CarSchema getProduct() {
            return this.carSchema;
        }
    }

    class Director {
        public void constructHondaEx1(Builder builder) {
            builder.setBrand("Honda")
                    .setColor("yellow")
                    .setName("Ex1Versions2");
            if (builder instanceof CarBuilder) {
                ((CarBuilder) builder).setSpeed(20.8);
            }
        }

        public void constructLambo(Builder builder) {
            builder.setBrand("Lambo")
                    .setColor("red")
                    .setName("adventure");
            if (builder instanceof CarBuilder) {
                ((CarBuilder) builder).setSpeed(70.1);
            }

        }

        public void constructToyotaB2(Builder builder) {
            builder.setBrand("Toyota")
                    .setColor("white")
                    .setName("B2");
            if (builder instanceof CarBuilder) {
                ((CarBuilder) builder).setSpeed(20.7);
            }
        }

        public void constructHondaSchema(Builder builder) {
            builder.setBrand("Honda")
                    .setColor("yellow")
                    .setName("Ex1Versions2");
            if (builder instanceof CarSchema) {
                ((CarSchema) builder).setManual(true);
            }
        }


        public void constructSchema(Builder builder) {
            builder.setBrand("Lambo")
                    .setColor("red")
                    .setName("adventure");
            if (builder instanceof CarSchemaBuilder) {
                ((CarSchemaBuilder) builder).setIsManual(false);
            }
        }

        public void constructToyotaB2Schema(Builder builder) {
            builder.setBrand("Toyota")
                    .setColor("white")
                    .setName("B2");
            if (builder instanceof CarSchemaBuilder) {
                ((CarSchemaBuilder) builder).setIsManual(false);
            }
        }

    }

    public void client() {
        Director d = new Director();
        CarBuilder carBuilder = new CarBuilder();
        CarSchemaBuilder carSchemaBuilder = new CarSchemaBuilder();
        d.constructLambo(carBuilder);
        d.constructHondaEx1(carSchemaBuilder);
        Car c = carBuilder.getProduct();
        System.out.println(c.toString());
        System.out.println(carSchemaBuilder.getProduct().toString());

    }

}
