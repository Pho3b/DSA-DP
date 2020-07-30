package Studying.design_patterns.strategy.auto_attack_concrete_implementations;

import Studying.design_patterns.strategy.AutoAttackStrategy;

public class MeleeAutoAttack implements AutoAttackStrategy {
    @Override
    public void autoAttack() {
        System.out.println("I'm big i'm strong, attacking with my muscles");
    }
}
