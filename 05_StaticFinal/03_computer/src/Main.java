public class Main {
    public static void main(String[] args) {

        TypeRam typeRam = TypeRam.valueOf("DDR2");
        TypeHardDisk typeHardDisk = TypeHardDisk.valueOf("SSD");
        TypeMonitor typeMonitor = TypeMonitor.IPS;
        TypeKeyboard typeKeyboard = TypeKeyboard.BLUETOOTH;

        Cpu cpu = new Cpu(1000, 1,"123", 10);
        Ram ram = new Ram(typeRam, 1000, 10);
        HardDisk hardDisk = new HardDisk(typeHardDisk, 1000, 10);
        Monitor monitor = new Monitor(typeMonitor, 20, 10);
        Keyboard keyboard = new Keyboard(typeKeyboard, false, 10);

        Computer comp1 = new Computer("LG", "Big", cpu, ram, hardDisk, monitor, keyboard);

        System.out.println(comp1);

        Cpu cpu1 = comp1.setCpuParametrs(2500, 8, "Athlon", 190);
        TypeKeyboard typeKeyboard1 = TypeKeyboard.NOBLUETOOTH;
        Keyboard keyboard1 = comp1.setKeyboardParametrs(typeKeyboard1, true, 200);
        Computer comp2 = new Computer("HP", "Tower", cpu1, ram, hardDisk, monitor, keyboard1);
        System.out.println(comp2);
    }
}
