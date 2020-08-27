package Studying.design_patterns.strategy.auto_attack_concrete_implementations;

import Studying.design_patterns.strategy.AutoAttackStrategy;

public class MagicAutoAttack implements AutoAttackStrategy {
    @Override
    public void autoAttack() {
        System.out.println("Take this Fireball ! I'm a top notch magician!");
    }
}