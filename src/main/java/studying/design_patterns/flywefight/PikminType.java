package studying.design_patterns.flywefight;

import java.awt.*;

/**
 * Here we manage all the EXTRINSIC Pikmin's object properties.
 */
public class PikminType {
    final private String name, power;
    final private Color color;
    final private int speed;


    /**
     * Default constructor
     *
     * @param name String
     * @param power String
     * @param color Color
     * @param speed int
     */
    PikminType(String name, String power, Color color, int speed) {
        this.name = name;
        this.power = power;
        this.color = color;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}
