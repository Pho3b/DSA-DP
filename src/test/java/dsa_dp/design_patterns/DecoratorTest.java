package dsa_dp.design_patterns;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import dsa_dp.design_patterns.decorator.salad_decorators.Ananas;
import dsa_dp.design_patterns.decorator.salad_decorators.CheesePieces;
import dsa_dp.design_patterns.decorator.salad_decorators.MeatPieces;
import dsa_dp.design_patterns.decorator.salad_decorators.Oil;
import dsa_dp.design_patterns.implementations.decorator_implementation.HawaiianSalad;
import dsa_dp.design_patterns.implementations.decorator_implementation.RomanianSalad;
import dsa_dp.design_patterns.implementations.decorator_implementation.Salad;

public class DecoratorTest {

    @Test
    public void correctAddingIngredientsTest() {
        Salad hawaiianSalad = new HawaiianSalad();
        hawaiianSalad.printDetails();

        hawaiianSalad = new Ananas(new Ananas(new Oil(new CheesePieces(hawaiianSalad))));
        Assertions.assertEquals("Hawaiian Salad - Cheese pieces- Oil - Ananas - Ananas  :   6.45",
                hawaiianSalad.printDetails());

        Salad romanianSalad = new RomanianSalad();
        Assertions.assertEquals("Romanian Salad  :   3.5", romanianSalad.printDetails());

        romanianSalad = new MeatPieces(romanianSalad);
        Assertions.assertEquals("Romanian Salad - Meat  :   4.6", romanianSalad.printDetails());

        romanianSalad = new MeatPieces(romanianSalad);
        Assertions.assertEquals("Romanian Salad - Meat - Meat  :   5.7", romanianSalad.printDetails());
    }
}
