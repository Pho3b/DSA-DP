package dsa_dp.design_patterns.visitor;

import dsa_dp.design_patterns.visitor.behaviours.UnitVisitor;

// The Unit represents the Element interface in the context of a Visitor design pattern.
public interface Unit {
    void accept(UnitVisitor visitor);
}
