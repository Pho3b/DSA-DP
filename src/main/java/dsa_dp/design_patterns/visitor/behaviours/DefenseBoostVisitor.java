package dsa_dp.design_patterns.visitor.behaviours;

import dsa_dp.design_patterns.visitor.Soldier;
import dsa_dp.design_patterns.visitor.Tank;

public class DefenseBoostVisitor implements UnitVisitor {
    private int defenseBoost;

    public DefenseBoostVisitor(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }


    @Override
    public void visit(Soldier soldier) {
        System.out.println("Soldier defense cannot be boosted!");
    }

    @Override
    public void visit(Tank tank) {
        tank.armor += this.defenseBoost;
        System.out.println("Tank armor boosted to " + tank.armor);
    }
}
