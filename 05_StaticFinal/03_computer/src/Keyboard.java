public class Keyboard {

    private final TypeKeyboard typeKeyboard;
    private final boolean backlight;
    private final int weight;

    public Keyboard(TypeKeyboard typeKeyboard, boolean backlight, int weight) {
        this.typeKeyboard = typeKeyboard;
        this.backlight = backlight;
        this.weight = weight;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public int getWeight() {
        return weight;
    }

    public TypeKeyboard getTypeKeyboard() {
        return typeKeyboard;
    }

    public String toString() {
        return "\tKeyboard: Type - " + typeKeyboard +
                ", Backlight - " + backlight +
                ", Weight - " + weight;
    }
}
