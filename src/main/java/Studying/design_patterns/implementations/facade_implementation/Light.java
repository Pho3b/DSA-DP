package Studying.design_patterns.implementations.facade_implementation;

public class Light extends SwimmingPoolComponent {
    private String lightColor = "white";

    public String setColor(String lightColor) {
        this.lightColor = lightColor;
        return "Light color changed to " +  this.lightColor;
    }

    public String getLightColor() {
        return lightColor;
    }
}
