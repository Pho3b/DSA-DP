package dsa_dp.design_patterns.visitor.behaviours;

import dsa_dp.design_patterns.visitor.Soldier;
import dsa_dp.design_patterns.visitor.Tank;

public class BuffVisitor implements UnitVisitor {
    private int buffAmount;

    public BuffVisitor(int buffAmount) {
        this.buffAmount = buffAmount;
    }

    @Override
    public void visit(Soldier soldier) {
        soldier.attackPower += buffAmount;
        System.out.println("Soldier attack increased! New Attack Power: " + soldier.attackPower);
    }

    @Override
    public void visit(Tank tank) {
        tank.attackPower += buffAmount;
        System.out.println("Tank attack increased! New Attack Power: " + tank.attackPower);
    }
}
