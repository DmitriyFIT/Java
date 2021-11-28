public class HardDisk {

    TypeHardDisk typeHardDisk;
    private final int volume;
    private final int weight;

    public HardDisk(TypeHardDisk typeHardDisk, int volume, int weight) {
        this.typeHardDisk = typeHardDisk;
        this.volume = volume;
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public int getWeight() {
        return weight;
    }

    public TypeHardDisk getTypeHardDisk() {
        return typeHardDisk;
    }
}
