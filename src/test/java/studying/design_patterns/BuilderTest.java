package studying.design_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.design_patterns.builder.Letter;
import studying.design_patterns.builder.enumerator.FontType;

public class BuilderTest {

    @Test
    public void onlyMandatoryPropertiesTest() {
        Letter letter = new Letter
                .LetterBuilder("Wedding announcement", "Frank", "Andrew")
                .build();

        Assertions.assertEquals(letter.getObject(), "Wedding announcement");
    }

    @Test
    public void buildingWithOptionalPropertiesTest() {
        Letter letter = new Letter
                .LetterBuilder("My Wedding !", "Frank", "Andrew")
                .body("I am going to get married !")
                .fontType(FontType.OPEN_SANS)
                .build();

        Assertions.assertEquals(letter.getObject(), "My Wedding !");
        Assertions.assertEquals(letter.getTo(), "Frank");
        Assertions.assertEquals(letter.getFrom(), "Andrew");
        Assertions.assertNotEquals(letter.getFontType(), FontType.TIMES_NEW_ROMAN);
        Assertions.assertEquals(letter.getFontType(), FontType.OPEN_SANS);
    }
}
