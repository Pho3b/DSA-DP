package studying.design_patterns.implementations.strategy_implementation;

import studying.design_patterns.strategy.AutoAttackStrategy;
import studying.design_patterns.strategy.auto_attack_concrete_implementations.MagicAutoAttack;

public class UserCharacter {
    private AutoAttackStrategy autoAttack;


    /**
     * Setting this character as a magician by default.
     */
    public UserCharacter() {
        this.autoAttack = new MagicAutoAttack();
    }

    /**
     * This method actually calls the method injected from the strategy pattern
     */
    public void autoAttack() {
        this.autoAttack.autoAttack();
    }

    /**
     * Here we can dynamically change the UserChar auto attack style.
     * We can even perform some further controls before setting it if necessary.
     *
     * @param autoAttackStrategy
     * @return boolean
     */
    public boolean setAutoAttackStrategy(AutoAttackStrategy autoAttackStrategy) {
            this.autoAttack = autoAttackStrategy;
            return true;
    }
}
