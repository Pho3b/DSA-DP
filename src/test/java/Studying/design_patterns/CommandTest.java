package Studying.design_patterns;

import studying.design_patterns.command.GroundUnit;
import studying.design_patterns.command.MoveToTarget;
import studying.design_patterns.command.SwitchWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Despite this being a test case this class  will be
 * treated as the "SENDER" in the context of the Command Design pattern.
 */
public class CommandTest {

    @Test
    public void executedCommandValueTest() {
        GroundUnit groundUnit = new GroundUnit();

        // Instantiating the needed Commands
        SwitchWeapon switchWeapon = new SwitchWeapon(groundUnit);
        MoveToTarget moveToTarget = new MoveToTarget(groundUnit);

        // Adding commands the the player commands list
        switchWeapon.execute();
        switchWeapon.execute();
        switchWeapon.execute();
        switchWeapon.undo();
        moveToTarget.execute();
        moveToTarget.undo();
        switchWeapon.execute();

        // Executing them here.
        // player.executeGroundUnitCommands();

        Assertions.assertEquals(groundUnit.getCurrentWeapon(), "sword");
    }

}
