package dsa_dp.design_patterns;

import dsa_dp.design_patterns.visitor.*;
import dsa_dp.design_patterns.visitor.behaviours.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitorTest {

    @Test
    public void VisitorDesignPatternInActionTest() {
        // Create game units
        Soldier soldier = new Soldier();
        Tank tank = new Tank();

        // Create visitors (behaviors)
        UnitVisitor attack = new AttackVisitor(40);
        UnitVisitor heal = new HealVisitor(30);
        UnitVisitor buff = new BuffVisitor(10);
        UnitVisitor defenseBoost = new DefenseBoostVisitor(50);

        // Apply attack
        System.out.println("Battle Begins!");
        Assertions.assertEquals(100, soldier.health);
        Assertions.assertEquals(300, tank.health);

        soldier.accept(attack);
        Assertions.assertEquals(60, soldier.health);
        tank.accept(attack);
        Assertions.assertEquals(290, tank.health);

        // Apply healing
        System.out.println("\nHealing Units...");
        soldier.accept(heal);
        Assertions.assertEquals(90, soldier.health);
        tank.accept(heal);
        Assertions.assertEquals(290, tank.health);


        // Apply buff
        System.out.println("\nBuffing Units...");
        Assertions.assertEquals(20, soldier.attackPower);
        Assertions.assertEquals(50, tank.attackPower);

        soldier.accept(buff);
        Assertions.assertEquals(30, soldier.attackPower);
        tank.accept(buff);
        Assertions.assertEquals(60, tank.attackPower);

        // Boost Defense
        System.out.println("\nBoosting Units Defense...");
        Assertions.assertEquals(30, tank.armor);

        soldier.accept(defenseBoost);
        tank.accept(defenseBoost);
        Assertions.assertEquals(80, tank.armor);
    }
}
