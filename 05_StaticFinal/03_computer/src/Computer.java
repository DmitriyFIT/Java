public class Computer {

    private final String vendor;
    private final String name;

    private final Cpu cpu;
    private final Ram ram;
    private final HardDisk hardDisk;
    private final Monitor monitor;
    private final Keyboard keyboard;

    public Computer(String vendor, String name, Cpu cpu, Ram ram, HardDisk hardDisk, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public Cpu setCpuParametrs(int fregency, int nuberCores, String manufactures, int weight) {
        return new Cpu(fregency, nuberCores, manufactures, weight);
    }

    public Ram setRamParametrs(TypeRam typeRam, int volume, int weight) {
        return new Ram(typeRam, volume, weight);
    }

    public HardDisk setHardDiskParametrs(TypeHardDisk typeHardDisk, int volume, int wieght) {
        return new HardDisk(typeHardDisk, volume, wieght);
    }

    public Monitor setMonitorParametrs(TypeMonitor typeMonitor, int sizeScreen, int weight) {
        return new Monitor(typeMonitor, sizeScreen, weight);
    }

    public Keyboard setKeyboardParametrs(TypeKeyboard typeKeyboard, boolean backLight, int weight) {
        return new Keyboard(typeKeyboard, backLight, weight);
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
