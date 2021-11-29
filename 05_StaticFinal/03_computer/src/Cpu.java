public class Cpu {

    private final int freqency;
    private final int numberCores;
    private final String manufactures;
    private final int wight;

    public Cpu(int freqency, int numberCores, String manufactures, int wight) {
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

    public String toString() {
        return "\tCPU: Freqency - " + freqency +
                ", Number Cores - " + numberCores +
                ", Manufactures - " + manufactures +
                ", Weight: " + wight + ";";
    }
}
