package Studying;

import Studying.algorithms.searching.BinarySearch;
import Studying.algorithms.searching.JumpSearch;
import Studying.algorithms.searching.LinearSearch;
import Studying.algorithms.sorting.SelectionSort;
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
import Studying.algorithms.sorting.BubbleSort;
import Studying.design_patterns.implementations.strategy_implementation.UserCharacter;
import Studying.design_patterns.strategy.auto_attack_concrete_implementations.MeleeAutoAttack;
import Studying.design_patterns.strategy.auto_attack_concrete_implementations.RangedAutoAttack;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        App main = new App();
        main.testLinearSearch();
    }

    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] test = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
        int[] res = binarySearch.search(test, 11);
        System.out.println("Found value : " + res[0] + " at index " + res[1]);
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

    /**
     * Bubble Sort algorithm demonstration
     */
    public void testBubbleSort() {
        ArrayList<Integer> testInput = new ArrayList<>(10);
        testInput.add(127);
        testInput.add(12);
        testInput.add(43);
        testInput.add(678);
        testInput.add(1);
        testInput.add(5);
        testInput.add(87);
        testInput.add(32);
        testInput.add(76);
        testInput.add(76);

        BubbleSort bs = new BubbleSort();
        System.out.println("ArrayList Before : " + testInput);
        System.out.println("ArrayList Sorted : " + bs.sort(testInput));
    }

    public void testSelectionSort() {
        ArrayList<Integer> testInput = new ArrayList<>(10);
        testInput.add(127);
        testInput.add(12);
        testInput.add(-43);

        SelectionSort selectionSort = new SelectionSort();
        System.out.println("ArrayList Before : " + testInput);
        System.out.println("ArrayList Sorted : " + selectionSort.sort(testInput));
    }

    public void testLinearSearch() {
        int[] test = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
        LinearSearch linearSearch = new LinearSearch();
        System.out.println(linearSearch.search(test, 6));
    }

    public void testJumpSearch() {
        int[] test = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11, 150, 154, 155, 189, 190, 210, 211, 212, 301, 390, 400};
        JumpSearch jumpSearch = new JumpSearch();
        System.out.println(jumpSearch.search(test, -1));
    }

}
