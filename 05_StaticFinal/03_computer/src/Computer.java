public class Computer {

    private final String vendor;
    private final String name;

    private Cpu cpu;
    private Ram ram;
    private  HardDisk hardDisk;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer(String vendor, String name, Cpu cpu, Ram ram, HardDisk hardDisk, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public Computer setParametrs(String vendor, String name, Cpu cpu, Ram ram, HardDisk hardDisk, Monitor monitor, Keyboard keyboard) {
        return new Computer(vendor, name, cpu, ram, hardDisk, monitor, keyboard);
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public int getTotalWeightComputer() {
        return cpu.getWight() + ram.getWeihgt() + hardDisk.getWeight() + monitor.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "\nVendor: " + vendor +
                "\nModel: " + name +
                "\n" + cpu +
                "\n" + ram +
                "\n" + hardDisk +
                "\n" + monitor +
                "\n" + keyboard +
                "\nTotal weight: " + getTotalWeightComputer();
    }
}
