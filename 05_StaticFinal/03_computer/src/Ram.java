public class Ram{

    private final TypeRam typeRam;
    private final int volume;
    private final int weihgt;

    public Ram(TypeRam typeRam, int volume, int weihgt) {
        this.typeRam = typeRam;
        this.volume = volume;
        this.weihgt = weihgt;
    }

    public int getVolume() {
        return volume;
    }

    public int getWeihgt() {
        return weihgt;
    }

    public TypeRam getTypeRam(){
        return typeRam;
    }

    public String toString() {
        return "\tRAM: Type - " + typeRam +
                ", Volume - " + volume +
                ", Weight - " + weihgt + ";";
    }
}
