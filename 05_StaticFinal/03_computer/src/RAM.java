public class RAM {

    TypeRAM typeRAM;
    private final int volume;
    private final int weihgt;

    public RAM(TypeRAM typeRAM, int volume, int weihgt) {
        this.typeRAM = typeRAM;
        this.volume = volume;
        this.weihgt = weihgt;
    }

    public int getVolume() {
        return volume;
    }

    public int getWeihgt() {
        return weihgt;
    }

    public TypeRAM getTypeRAM(){
        return typeRAM;
    }
}
