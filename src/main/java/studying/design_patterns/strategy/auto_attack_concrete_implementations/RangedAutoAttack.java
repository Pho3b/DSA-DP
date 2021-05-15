package studying.design_patterns.strategy.auto_attack_concrete_implementations;

import studying.design_patterns.strategy.AutoAttackStrategy;

public class RangedAutoAttack implements AutoAttackStrategy {
    @Override
    public String autoAttack() {
        String attack = "Attacking from the distance, they'll never get me";
        System.out.println(attack);

        return attack;
    }
}
