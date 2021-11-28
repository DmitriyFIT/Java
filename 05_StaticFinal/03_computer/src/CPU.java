public class CPU {

    private final int freqency;
    private final int numberCores;
    private final String manufactures;
    private final int wight;

    public CPU(int freqency, int numberCores, String manufactures, int wight) {
        this.freqency = freqency;
        this.numberCores = numberCores;
        this.manufactures = manufactures;
        this.wight = wight;
    }

    public int getFreqency() {
        return freqency;
    }

    public int getNumberCores() {
        return numberCores;
    }

    public String getManufactures() {
        return manufactures;
    }

    public int getWight() {
        return wight;
    }
}
