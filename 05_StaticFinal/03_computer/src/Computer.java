public class Computer {

    private final String vendor;
    private final String name;

    private final CPU cpu;
    private final RAM ram;
    private final HardDisk hardDisk;
    private final Monitor monitor;
    private final Keyboard keyboard;

    public Computer(String vendor, String name, CPU cpu, RAM ram, HardDisk hardDisk, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    /*public int getTotalWieghtComputer() {
        return cpu.getWight() + ram.getWeihgt() + hardDisk.getWeight() + monitor.getWeight() + keyboard.getWeight();
    }*/

    public CPU setCpuParametrs(int fregency, int nuberCores, String manufactures, int weight) {
        return new CPU(fregency, nuberCores, manufactures, weight);
    }

    public RAM setRamParametrs(TypeRAM typeRAM, int volume, int weight) {
        return new RAM(typeRAM, volume, weight);
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

    public CPU getCpu() {
        return cpu;
    }

    public RAM getRam() {
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

    public String getCpuInfo() {
        return  "\n\tЧастота: " + cpu.getFreqency() +
                "\n\tКоличество ядер: " + cpu.getNumberCores() +
                "\n\tПроизводиетль: " + cpu.getManufactures() +
                "\n\tВес: " + cpu.getWight();
    }

    public String getRamInfo() {
        return "\nRAM:\n\tТип:" + ram.getTypeRAM() +
                "\n\tОбъем памяти: " + ram.getVolume() +
                "\n\tВес: " + ram.getWeihgt();
    }

    public String getHardDiskInfo() {
        return "\nHardDisk:\n\tТип диска: " + hardDisk.getTypeHardDisk() +
                "\n\tОбъем: " + hardDisk.getVolume() +
                "\n\tВес: " + hardDisk.getWeight();
    }

    public String getMonitorInfo() {
        return  "\nMonitor:\n\tТип монитора: " + monitor.getTypeMonitor() +
                "\n\tДиагональ понитора" + monitor.getSizeScreen() +
                "\n\tВес: " + monitor.getWeight();
    }

    public String getKeyboardInfo() {
        if (keyboard.isBacklight()) {
            return "\nKeyboard:\n\tТип клавиатуры: " + keyboard.getTypeKeyboard() + " с подсветкой" +
                    "\n\tВес: " + keyboard.getWeight();
        }
        else {
            return "\nKeyboard:\n\tТип клавиатуры: " + keyboard.getTypeKeyboard() + " без подсветки" +
                    "\n\tВес: " + keyboard.getWeight();
        }
    }

    public void print() {
        String total = "\nПроизводитель: " + vendor + "\nМодель: " + name + "\nПроцессор: " +
                 getCpuInfo() + getRamInfo() + getHardDiskInfo() + getMonitorInfo() + getKeyboardInfo() +
                "\n\nTOTAL WEIGHT: " + getTotalWeightComputer();
        System.out.println(total);
    }

    public int getTotalWeightComputer() {
        return cpu.getWight() + ram.getWeihgt() + hardDisk.getWeight() + monitor.getWeight() + keyboard.getWeight();
    }
}
