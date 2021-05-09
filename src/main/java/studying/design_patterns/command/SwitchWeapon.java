package studying.design_patterns.command;

public class SwitchWeapon implements UnitCommand {
    private final GroundUnit groundUnit;


    public SwitchWeapon(GroundUnit groundUnit) {
        this.groundUnit = groundUnit;
    }

    @Override
    public void execute() {
        this.groundUnit.switchWeapon();
    }

    @Override
    public void undo() {
        this.groundUnit.undoWeaponSwitch();
    }
}
