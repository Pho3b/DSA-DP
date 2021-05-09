package studying;

import studying.data_structures.disjoint_set.DisjointSet;
import studying.design_patterns.implementations.decorator_implementation.HawaiianSalad;
import studying.design_patterns.implementations.decorator_implementation.RomanianSalad;
import studying.design_patterns.implementations.decorator_implementation.Salad;
import studying.design_patterns.decorator.salad_decorators.Ananas;
import studying.design_patterns.decorator.salad_decorators.CheesePieces;
import studying.design_patterns.decorator.salad_decorators.MeatPieces;
import studying.design_patterns.decorator.salad_decorators.Oil;
import studying.design_patterns.implementations.observer_implementation.Foul;
import studying.design_patterns.implementations.observer_implementation.Goal;
import studying.design_patterns.implementations.observer_implementation.MatchScores;
import studying.design_patterns.implementations.strategy_implementation.UserCharacter;
import studying.design_patterns.strategy.auto_attack_concrete_implementations.MeleeAutoAttack;
import studying.design_patterns.strategy.auto_attack_concrete_implementations.RangedAutoAttack;

import java.util.Hashtable;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        genericTest();
    }

    public static void genericTest() {
        // Generating the bijection table
        Hashtable<Character, Integer> bt = new Hashtable<>();
        bt.put('E', 0);
        bt.put('F', 1);
        bt.put('I', 2);
        bt.put('D', 3);
        bt.put('C', 4);
        bt.put('A', 5);
        bt.put('J', 6);
        bt.put('L', 7);
        bt.put('G', 8);
        bt.put('K', 9);
        bt.put('B', 10);
        bt.put('H', 11);

        // Generating the disjoint set
        DisjointSet disjointSet = new DisjointSet(12);
        disjointSet.union(bt.get('C'), bt.get('K'));
        disjointSet.union(bt.get('F'), bt.get('E'));
        disjointSet.union(bt.get('A'), bt.get('J'));
        disjointSet.union(bt.get('A'), bt.get('B'));
        disjointSet.union(bt.get('C'), bt.get('D'));
        disjointSet.union(bt.get('D'), bt.get('I'));
        disjointSet.union(bt.get('L'), bt.get('F'));
        disjointSet.union(bt.get('C'), bt.get('A'));
        disjointSet.union(bt.get('A'), bt.get('B'));
        disjointSet.union(bt.get('H'), bt.get('G'));
        disjointSet.union(bt.get('H'), bt.get('F'));
        disjointSet.union(bt.get('H'), bt.get('B'));
        disjointSet.find(bt.get('E'));
        disjointSet.find(bt.get('H'));
        disjointSet.print();
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
