package dsa_dp.design_patterns.visitor;

import dsa_dp.design_patterns.visitor.behaviours.UnitVisitor;

public class Tank implements Unit {
    public int health = 300;
    public int attackPower = 50;
    public int armor = 30;

    @Override
    public void accept(UnitVisitor visitor) {
        visitor.visit(this);
    }
}