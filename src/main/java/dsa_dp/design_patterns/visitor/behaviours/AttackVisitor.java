package dsa_dp.design_patterns.visitor.behaviours;

import dsa_dp.design_patterns.visitor.Soldier;
import dsa_dp.design_patterns.visitor.Tank;

public class AttackVisitor implements UnitVisitor {
    private int damage;

    public AttackVisitor(int damage) {
        this.damage = damage;
    }

    @Override
    public void visit(Soldier soldier) {
        soldier.health -= damage;
        System.out.println("Soldier takes " + damage + " damage! Health left: " + soldier.health);
    }

    @Override
    public void visit(Tank tank) {
        int actualDamage = Math.max(damage - tank.armor, 0);
        tank.health -= actualDamage;
        System.out.println("Tank takes " + actualDamage + " damage! Health left: " + tank.health);
    }
}
