package Studying.design_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.design_patterns.implementations.strategy_implementation.UserCharacter;
import studying.design_patterns.strategy.auto_attack_concrete_implementations.MeleeAutoAttack;
import studying.design_patterns.strategy.auto_attack_concrete_implementations.RangedAutoAttack;

public class StrategyTest {

    @Test
    public void hookMethodImplementedTest() {
        UserCharacter userCharacter = new UserCharacter();

        // The user auto attacks as a magician by default.
        Assertions.assertEquals(userCharacter.autoAttack(), "Take this Fireball ! I'm a top notch magician!");

        // Changing his auto attack style to ranged.
        userCharacter.setAutoAttackStrategy(new RangedAutoAttack());
        Assertions.assertEquals(userCharacter.autoAttack(), "Attacking from the distance, they'll never get me");

        // For the sake of completeness we set his auto attack style as melee too.
        userCharacter.setAutoAttackStrategy(new MeleeAutoAttack());
        Assertions.assertEquals(userCharacter.autoAttack(), "I'm big i'm strong, attacking with my muscles");
    }
}
