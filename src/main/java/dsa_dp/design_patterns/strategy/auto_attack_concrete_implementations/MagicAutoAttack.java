package dsa_dp.design_patterns.strategy.auto_attack_concrete_implementations;

import dsa_dp.design_patterns.strategy.AutoAttackStrategy;

public class MagicAutoAttack implements AutoAttackStrategy {
    @Override
    public String autoAttack() {
        String attack = "Take this Fireball ! I'm a top notch magician!";
        System.out.println(attack);

        return attack;
    }
}
