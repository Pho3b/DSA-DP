package design_patterns.strategy.auto_attack_concrete_implementations;

import design_patterns.strategy.AutoAttackStrategy;

public class RangedAutoAttack implements AutoAttackStrategy {
    @Override
    public void autoAttack() {
        System.out.println("Attacking from the distance, they'll never get me");
    }
}
