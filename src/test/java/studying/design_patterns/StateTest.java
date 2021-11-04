package studying.design_patterns;

import studying.design_patterns.state.EchoStudio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateTest {

    @Test
    public void defaultStateTest() {
        EchoStudio echoStudio = new EchoStudio();
        echoStudio.play();
        echoStudio.stop();
        echoStudio.stop();
        echoStudio.unplug();
        echoStudio.play();
        echoStudio.plug();
        echoStudio.disconnect();
        echoStudio.play();
        echoStudio.connect();
        echoStudio.play();

        Assertions.assertTrue(true);
    }
}
