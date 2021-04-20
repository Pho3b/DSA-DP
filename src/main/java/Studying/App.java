package Studying;

import Studying.data_structures.heap.BinaryHeap;
import Studying.design_patterns.implementations.decorator_implementation.HawaiianSalad;
import Studying.design_patterns.implementations.decorator_implementation.RomanianSalad;
import Studying.design_patterns.implementations.decorator_implementation.Salad;
import Studying.design_patterns.decorator.salad_decorators.Ananas;
import Studying.design_patterns.decorator.salad_decorators.CheesePieces;
import Studying.design_patterns.decorator.salad_decorators.MeatPieces;
import Studying.design_patterns.decorator.salad_decorators.Oil;
import Studying.design_patterns.implementations.observer_implementation.Foul;
import Studying.design_patterns.implementations.observer_implementation.Goal;
import Studying.design_patterns.implementations.observer_implementation.MatchScores;
import Studying.design_patterns.implementations.strategy_implementation.UserCharacter;
import Studying.design_patterns.strategy.auto_attack_concrete_implementations.MeleeAutoAttack;
import Studying.design_patterns.strategy.auto_attack_concrete_implementations.RangedAutoAttack;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        genericTest();
    }

    public static void genericTest() {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(20);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
        binaryHeap.insert(12);
        binaryHeap.insert(8);
        binaryHeap.insert(6);
        binaryHeap.insert(13);
        binaryHeap.insert(19);
        binaryHeap.insert(13);
        binaryHeap.insert(12);
        binaryHeap.insert(11);
        binaryHeap.insert(7);
        binaryHeap.insert(14);

        binaryHeap.print();
    }

    public void testStrategyPattern() {
        UserCharacter userCharacter = new UserCharacter();

        // The user auto attacks as a magician by default.
        userCharacter.autoAttack();

        // Changing his auto attack style to ranged.
        userCharacter.setAutoAttackStrategy(new RangedAutoAttack());
        userCharacter.autoAttack();

        // For the sake of completeness we set his auto attack style as melee too.
        userCharacter.setAutoAttackStrategy(new MeleeAutoAttack());
        userCharacter.autoAttack();
    }


    public void testDecoratorPattern() {
        Salad hawaiianSalad = new HawaiianSalad();
        hawaiianSalad.printDetails();

        // Adding double Ananas and Oil
        hawaiianSalad = new Ananas(new Ananas(new Oil(new CheesePieces(hawaiianSalad))));
        hawaiianSalad.printDetails();

        Salad romanianSalad = new RomanianSalad();
        romanianSalad = new MeatPieces(romanianSalad);
        romanianSalad = new MeatPieces(romanianSalad);
        romanianSalad.printDetails();
    }


    /**
     * Observer design pattern demonstration
     */
    public void testObserverDesignPatter() {
        MatchScores matchScores = new MatchScores();
        Goal goal = new Goal(matchScores);
        Foul foul = new Foul(matchScores);

        matchScores.payload.goals = 3;
        matchScores.payload.fouls = 12;
        matchScores.notifyObservers();

        matchScores.unregisterObserver(goal);
        matchScores.notifyObservers();

        matchScores.unregisterObserver(foul);
        matchScores.notifyObservers();
    }
}
