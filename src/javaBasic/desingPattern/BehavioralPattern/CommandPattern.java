package javaBasic.desingPattern.BehavioralPattern;

public class CommandPattern {

    interface ElectronicDevice {
        public void on();

        public void off();

        public void volUp();

        public void volDown();

    }

    class Television implements ElectronicDevice {

        @Override
        public void on() {
            System.out.println("On");
        }

        @Override
        public void off() {
            System.out.println("off");
        }

        @Override
        public void volUp() {
            System.out.println("volUp");
        }

        @Override
        public void volDown() {
            System.out.println("volDown");
        }
    }

    interface Command {
        public void execute();
    }

    class TurnTvOn implements Command {

        ElectronicDevice electronicDevice;

        public TurnTvOn(ElectronicDevice electronicDevice) {
            this.electronicDevice = electronicDevice;
        }

        @Override
        public void execute() {
            electronicDevice.on();
        }
    }

    class TurnTvOff implements Command {
        ElectronicDevice electronicDevice;

        public TurnTvOff(ElectronicDevice electronicDevice) {
            this.electronicDevice = electronicDevice;
        }

        @Override
        public void execute() {
            electronicDevice.off();
        }

    }

    class DeviceButton {
        Command theCommand;

        public DeviceButton(Command theCommand) {
            this.theCommand = theCommand;
        }

        public void press() {
            theCommand.execute();
        }
    }

    class TvRemote {
        ElectronicDevice electronicDevice = new Television();
    }

    public void playRemote(){
        ElectronicDevice electronicDevice = new Television();

        TurnTvOn onCommand = new TurnTvOn(electronicDevice);

        DeviceButton deviceButton = new DeviceButton(onCommand);

        deviceButton.press();
    }

}
