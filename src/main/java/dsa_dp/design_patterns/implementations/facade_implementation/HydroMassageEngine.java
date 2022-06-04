package dsa_dp.design_patterns.implementations.facade_implementation;

public class HydroMassageEngine extends SwimmingPoolComponent {
    private static final int  MIN_INTENSITY_VALUE = 0;
    private static final int MAX_INTENSITY_VALUE = 100;
    private int intensityValue = 0;

    public String setIntensity(int intensityValue) {
        if (intensityValue > 0 && intensityValue < 100) {
            this.intensityValue = intensityValue;
            return "Intensity set to " + this.intensityValue;
        }

        return "Cannot set Intensity, the value must be between " + MIN_INTENSITY_VALUE + " and " + MAX_INTENSITY_VALUE;
    }

    public int getIntensityValue() {
        return intensityValue;
    }
}
