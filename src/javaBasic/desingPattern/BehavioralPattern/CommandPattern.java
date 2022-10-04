package javaBasic.desingPattern.BehavioralPattern;

import kotlin.reflect.KFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CommandPattern {

    // GUI (controller): receive input and show output
    // GUI needs to map input and perform different logic according to input
    // business layer: perform business logic
    // GUI not need to know which biz layer to map and Command objects server as links to execute related layer

    static Map<String, BiConsumer<Invoker, Robot>> functionMap = new HashMap<>();

    {
        functionMap.put("mf", (invoker, robot) -> invoker.addCommand(new MoveForward(robot)));
        functionMap.put("mb", (invoker, robot) -> invoker.addCommand(new MoveBackward(robot)));
        functionMap.put("fu", (invoker, robot) -> invoker.addCommand(new FlyUp(robot)));
        functionMap.put("fd", (invoker, robot) -> invoker.addCommand(new FlyDown(robot)));
    }

    class Robot {
        private int x;
        private int y;

        public Robot() {
            this.x = 0;
            this.y = 0;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    abstract class Command {
        private Robot robot;

        public Command(Robot robot) {
            this.robot = robot;
        }

        public Robot getRobot() {
            return robot;
        }

        abstract void execute();
    }

    class MoveForward extends Command {
        public MoveForward(Robot robot) {
            super(robot);
        }

        @Override
        public void execute() {
            int currentX = this.getRobot().getX();
            this.getRobot().setX(++currentX);
        }

    }

    class MoveBackward extends Command {

        public MoveBackward(Robot robot) {
            super(robot);
        }

        @Override
        void execute() {
            int currentX = this.getRobot().getX();
            this.getRobot().setY(--currentX);
        }
    }

    class FlyUp extends Command {
        public FlyUp(Robot robot) {
            super(robot);
        }

        @Override
        void execute() {
            int currentY = this.getRobot().getY();
            this.getRobot().setY(++currentY);
        }
    }

    class FlyDown extends Command {
        public FlyDown(Robot robot) {
            super(robot);
        }

        @Override
        void execute() {
            int currentY = this.getRobot().getY();
            this.getRobot().setY(--currentY);
        }
    }

    public class Invoker {
        private List<Command> commandList = new ArrayList<>();

        public void addCommand(Command c) {
            commandList.add(c);
        }

        public void executeCommands() {
            for (Command c : commandList) {
                c.execute();
            }
        }
    }

    public void client() {
        // httpRequest with list of operation
        // e.g. mf mf fu fd mf fu fd mb mf
        List<String> commandsFromRequest = List.of("mf", "mf", "fu", "fd", "mf", "fu", "fu", "mb", "mf");
        Robot target = new Robot();
        Invoker invoker = new Invoker();
        for (String s : commandsFromRequest) {
            functionMap.get(s).accept(invoker, target);
        }

        invoker.executeCommands();
        System.out.println(target.toString());


    }


}
