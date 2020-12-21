package Studying.design_patterns;

import Studying.design_patterns.command.GroundUnit;
import Studying.design_patterns.command.MoveToTarget;
import Studying.design_patterns.command.SwitchWeapon;
import org.junit.jupiter.api.Test;


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

        org.junit.Assert.assertEquals(groundUnit.getCurrentWeapon(), "sword");
    }

}
