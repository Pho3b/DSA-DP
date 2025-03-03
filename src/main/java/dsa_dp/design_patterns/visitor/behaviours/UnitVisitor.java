package dsa_dp.design_patterns.visitor.behaviours;

import dsa_dp.design_patterns.visitor.Soldier;
import dsa_dp.design_patterns.visitor.Tank;

public interface UnitVisitor {
    void visit(Soldier soldier);
    void visit(Tank tank);
}
