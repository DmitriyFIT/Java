public class Keyboard {

    TypeKeyboard typeKeyboard;
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
}
