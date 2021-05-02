package Studying;

import Studying.data_structures.disjoint_set.DisjointSet;
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

import java.util.Hashtable;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        genericTest();
    }

    public static void genericTest() {
        // Generating the bijection table
        Hashtable<Character, Integer> bijectionTable = new Hashtable<>();
        bijectionTable.put('E', 0);
        bijectionTable.put('F', 1);
        bijectionTable.put('I', 2);
        bijectionTable.put('D', 3);
        bijectionTable.put('C', 4);
        bijectionTable.put('A', 5);
        bijectionTable.put('J', 6);
        bijectionTable.put('L', 7);
        bijectionTable.put('G', 8);
        bijectionTable.put('K', 9);
        bijectionTable.put('B', 10);
        bijectionTable.put('H', 11);

        // Generating the disjoint set
        DisjointSet disjointSet = new DisjointSet(12);
        disjointSet.union(bijectionTable.get('C'), bijectionTable.get('K'));
        disjointSet.union(bijectionTable.get('F'), bijectionTable.get('E'));
        disjointSet.union(bijectionTable.get('A'), bijectionTable.get('J'));
        disjointSet.union(bijectionTable.get('A'), bijectionTable.get('B'));
        disjointSet.union(bijectionTable.get('C'), bijectionTable.get('D'));
        disjointSet.union(bijectionTable.get('D'), bijectionTable.get('I'));
        disjointSet.union(bijectionTable.get('L'), bijectionTable.get('F'));
        disjointSet.union(bijectionTable.get('C'), bijectionTable.get('A'));
        disjointSet.union(bijectionTable.get('A'), bijectionTable.get('B'));
        disjointSet.union(bijectionTable.get('H'), bijectionTable.get('G'));
        disjointSet.union(bijectionTable.get('H'), bijectionTable.get('F'));
        disjointSet.union(bijectionTable.get('H'), bijectionTable.get('B'));
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
