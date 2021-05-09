package studying.design_patterns.implementations.facade_implementation;

public class HeatingEngine extends SwimmingPoolComponent {
    private int temperature = 25; // Degrees

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
