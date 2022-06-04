package dsa_dp.design_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dsa_dp.design_patterns.flyweight.PikminGroup;
import dsa_dp.design_patterns.flyweight.PikminTypeFactory;

import java.awt.*;

public class FlyWeightTest {

    @Test
    public void correctNumberOfCachedObjects() {
        PikminGroup pikminGroup = new PikminGroup();
        Assertions.assertEquals(0, PikminTypeFactory.getCachedPikminsTypeNumber());

        pikminGroup.spawnPikmin(0, 0, "Red Pikmin", "Fire resistance", Color.RED, 8);
        pikminGroup.spawnPikmin(2, 4, "Red Pikmin", "Fire resistance", Color.RED, 8);
        pikminGroup.spawnPikmin(5, 2, "Red Pikmin", "Fire resistance", Color.RED, 8);
        Assertions.assertEquals(1, PikminTypeFactory.getCachedPikminsTypeNumber());

        pikminGroup.spawnPikmin(78, 15, "Blue Pikmin", "Fire resistance", Color.BLUE, 8);
        pikminGroup.spawnPikmin(2, 86, "Yellow Pikmin", "Fire resistance", Color.YELLOW, 8);
        pikminGroup.spawnPikmin(32, 87, "Yellow Pikmin", "Fire resistance", Color.YELLOW, 8);

        Assertions.assertEquals(3, PikminTypeFactory.getCachedPikminsTypeNumber());
    }
}
