package dsa_dp.design_patterns.visitor.behaviours;

import dsa_dp.design_patterns.visitor.Soldier;
import dsa_dp.design_patterns.visitor.Tank;

public class HealVisitor implements UnitVisitor {
    private int healAmount;

    public HealVisitor(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void visit(Soldier soldier) {
        soldier.health += healAmount;
        System.out.println("Soldier healed by " + healAmount + "! New health: " + soldier.health);
    }

    @Override
    public void visit(Tank tank) {
        System.out.println("Tanks cannot be healed!");
    }
}
