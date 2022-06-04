package dsa_dp.design_patterns.strategy.auto_attack_concrete_implementations;

import dsa_dp.design_patterns.strategy.AutoAttackStrategy;

public class MeleeAutoAttack implements AutoAttackStrategy {
    @Override
    public String autoAttack() {
        String attack = "I'm big i'm strong, attacking with my muscles";
        System.out.println(attack);

        return attack;
    }
}
