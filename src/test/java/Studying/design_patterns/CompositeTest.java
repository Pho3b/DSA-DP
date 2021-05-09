package Studying.design_patterns;

import studying.design_patterns.composite.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompositeTest {

    @Test
    public void compositeIllustrativeTest() {
        Client client = new Client();
        client.speakersTree.play();
        Assertions.assertTrue(client.speakersTree.isPlaying());

        client.speakersTree.stop();
        Assertions.assertFalse(client.speakersTree.isPlaying());
    }
}
