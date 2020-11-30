package Studying.design_patterns.command;

public class MoveToTarget implements UnitCommand {
    private final GroundUnit groundUnit;


    public MoveToTarget(GroundUnit groundUnit) {
        this.groundUnit = groundUnit;
    }

    @Override
    public void execute() {
        this.groundUnit.moveToTarget();
    }

    @Override
    public void undo() {
        System.out.println("Not implemented");
    }
}
