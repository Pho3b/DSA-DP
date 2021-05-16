package studying;

import studying.data_structures.tree.BinarySearchTree;
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


public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(20);
        bst.insert(10);
        bst.insert(31);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(42);
        bst.insert(2);
        bst.insert(12);
        bst.insert(19);
        bst.insert(35);
        bst.insert(47);
        bst.insert(11);
        bst.insert(14);
        bst.insert(33);
        bst.insert(37);
        bst.insert(36);
        bst.insert(38);

        bst.print();
        bst.delete(5);
        bst.print();
        bst.delete(2);
        bst.print();

        bst.delete(35);
        bst.print();

        bst.delete(12);
        bst.print();
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
