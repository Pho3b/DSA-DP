package dsa_dp.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dsa_dp.algorithms.string.PermutationInString;


public class PermutationInStringTest {

    @Test
    public void permutationIsPresentTest() {
        PermutationInString permInString = new PermutationInString();

        Assertions.assertTrue(permInString.check("ab", "jldsfbalkjlkj"));
        Assertions.assertTrue(permInString.check("ciao", "lkjlcioafasf"));
        Assertions.assertTrue(permInString.check("andrea", "jlksjaerdnajlandre"));
        Assertions.assertTrue(permInString.check("oi", "ioioioioio"));
        Assertions.assertTrue(permInString.check("joy", "ancoranonojysjljlk"));
        Assertions.assertTrue(permInString.check("a", "a"));
        Assertions.assertTrue(permInString.check("ba", "ab"));
    }

    @Test
    public void permutationIsNotPresentTest() {
        PermutationInString permInString = new PermutationInString();

        Assertions.assertFalse(permInString.check("ab", "dasfdsfasdf"));
        Assertions.assertFalse(permInString.check("ciao", "hhh"));
        Assertions.assertFalse(permInString.check("andrea", "djtyufadg"));
        Assertions.assertFalse(permInString.check("oi", "ad"));
        Assertions.assertFalse(permInString.check("joy", "hdfghdad"));
        Assertions.assertFalse(permInString.check("a", "sfdf"));
        Assertions.assertFalse(permInString.check("ba", "hgfgadsa"));
    }

    @Test
    public void invalidInputTest() {
        PermutationInString permInString = new PermutationInString();

        Assertions.assertFalse(permInString.check("sdfasfasdf", "a"));
        Assertions.assertFalse(permInString.check("ciaociao", "ciao"));
    }
}
