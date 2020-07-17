import algorithms.searching.BinarySearch;
import algorithms.sorting.SelectionSort;
import decorator_implementation.HawaiianSalad;
import decorator_implementation.RomanianSalad;
import decorator_implementation.Salad;
import design_patterns.decorator.salad_decorators.Ananas;
import design_patterns.decorator.salad_decorators.CheesePieces;
import design_patterns.decorator.salad_decorators.MeatPieces;
import design_patterns.decorator.salad_decorators.Oil;
import observer_implementation.Foul;
import observer_implementation.Goal;
import observer_implementation.MatchScores;
import algorithms.sorting.BubbleSort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.testBinarySearch();
    }

    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] test = new int[] {-21, -1, 1, 3, 4 ,5 ,6 ,10, 11};
        int[] res = binarySearch.search(test, 11);
        System.out.println("Found value : " + res[0] + " at index " + res[1]);
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

}
