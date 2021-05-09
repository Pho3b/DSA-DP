package studying.design_patterns.abstract_factory.factories;

import studying.design_patterns.abstract_factory.slider.Slider;
import studying.design_patterns.abstract_factory.slider.WindowsSlider;
import studying.design_patterns.abstract_factory.toggle.Toggle;
import studying.design_patterns.abstract_factory.toggle.WindowsToggle;

public class WindowsGuiFactory implements GuiFactory {

    @Override
    public Toggle createToggle() {
        return new WindowsToggle();
    }

    @Override
    public Slider createSlider() {
        return new WindowsSlider();
    }
}
