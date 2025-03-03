package dsa_dp.design_patterns.visitor;

import dsa_dp.design_patterns.visitor.behaviours.UnitVisitor;

public class Soldier implements Unit {
    public int health = 100;
    public int attackPower = 20;

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
    }
}