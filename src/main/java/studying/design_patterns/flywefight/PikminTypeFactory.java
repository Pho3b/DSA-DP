package studying.design_patterns.flywefight;

import java.awt.*;
import java.util.HashMap;

/**
 * Here we decouple and encapsulate the new type creation and caching systems
 */
public class PikminTypeFactory {
    private static final HashMap<String, PikminType> pikminTypes = new HashMap<>();


    /**
     * Checks if a Pikmin type with the given name already exists, in that case it returns a pointer to it.
     * Otherwise returns a new PikminType object populated with the given values
     *
     * @param name  String
     * @param power String
     * @param color Color
     * @return PikminType
     */
    public static PikminType generateType(String name, String power, Color color, int speed) {
        PikminType res = pikminTypes.get(name);

        if (res == null) {
            res = new PikminType(name, power, color, speed);
            pikminTypes.put(name, res);
        }

        return res;
    }

    /**
     * Returns the number of currently cached types of Pikmin.
     *
     * @return int
     */
    public static int getCachedPikminsTypeNumber() {
        return pikminTypes.size();
    }
}
