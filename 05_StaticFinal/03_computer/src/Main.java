public class Main {
    public static void main(String[] args) {

        TypeRAM typeRAM = TypeRAM.valueOf("DDR2");
        TypeHardDisk typeHardDisk = TypeHardDisk.valueOf("SSD");
        TypeMonitor typeMonitor = TypeMonitor.IPS;
        TypeKeyboard typeKeyboard = TypeKeyboard.BLUETOOTH;

        CPU cpu = new CPU(1000, 1,"123", 10);
        RAM ram = new RAM(typeRAM, 1000, 10);
        HardDisk hardDisk = new HardDisk(typeHardDisk, 1000, 10);
        Monitor monitor = new Monitor(typeMonitor, 20, 10);
        Keyboard keyboard = new Keyboard(typeKeyboard, false, 10);

        Computer comp1 = new Computer("LG", "Big", cpu, ram, hardDisk, monitor, keyboard);
        comp1.print();

        CPU cpu1 = comp1.setCpuParametrs(2500, 8, "Athlon", 190);
        TypeKeyboard typeKeyboard1 = TypeKeyboard.NOBLUETOOTH;
        Keyboard keyboard1 = comp1.setKeyboardParametrs(typeKeyboard1, true, 200);
        Computer comp2 = new Computer("HP", "Tower", cpu1, ram, hardDisk, monitor, keyboard1);
        comp2.print();
    }
}
