package Studying.design_patterns;

import Studying.design_patterns.command.GroundUnit;
import Studying.design_patterns.command.MoveToTarget;
import Studying.design_patterns.command.Player;
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
        Player player = new Player();
        player.takeUnitCommand(switchWeapon);
        player.takeUnitCommand(switchWeapon);
        player.takeUnitCommand(moveToTarget);
        player.takeUnitCommand(switchWeapon);

        // Executing them here.
        player.executeGroundUnitCommands();
        player.undoLastGroundUnitCommand();

        org.junit.Assert.assertEquals(groundUnit.getCurrentWeapon(), "spear");
    }

}
