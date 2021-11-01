package studying.design_patterns.flyweight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PikminGroup {
    List<Pikmin> pikmins = new ArrayList<>();


    /**
     * Returns a new Pikmin with the given properties.
     * Under the hood it calls the 'PikminTypeFactory.generateType()' that caches
     * all the Intrinsic properties
     *
     * @param x     int
     * @param y     int
     * @param name  String
     * @param power String
     * @param color Color
     * @param speed int
     */
    public Pikmin spawnPikmin(int x, int y, String name, String power, Color color, int speed) {
        PikminType pikminType = PikminTypeFactory.generateType(name, power, Color.RED, 8);
        Pikmin pikmin = new Pikmin(1, 32, pikminType);
        pikmins.add(pikmin);

        return pikmin;
    }
}
