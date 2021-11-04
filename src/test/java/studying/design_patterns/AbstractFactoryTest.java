package studying.design_patterns;

import studying.design_patterns.abstract_factory.factories.GnomeGuiFactory;
import studying.design_patterns.abstract_factory.factories.GuiFactory;
import studying.design_patterns.abstract_factory.factories.WindowsGuiFactory;
import studying.design_patterns.abstract_factory.slider.Slider;
import studying.design_patterns.abstract_factory.toggle.Toggle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {

    /**
     * The client doesn't need to know which factory it is working with since
     * it can work with it's interface.
     * This way it will have a layer of abstraction that decouples it from the "factory creator" object.
     */
    @Test
    public void compositeIllustrativeTest() {
        String osName = System.getProperty("os.name").toLowerCase();
        GuiFactory guiFactory;

        // We could also delegate this piece of code to another object
        // that can return the correct factory based on some conditions.
        if (osName.equals("ubuntu")) {
            guiFactory = new GnomeGuiFactory();
        } else {
            guiFactory = new WindowsGuiFactory();
        }

        Slider slider = guiFactory.createSlider();
        Toggle toggle = guiFactory.createToggle();

        Assertions.assertEquals(slider.init(), "WindowsSlider initialized");
        Assertions.assertEquals(toggle.init(), "WindowsToggle initialized");
    }
}
