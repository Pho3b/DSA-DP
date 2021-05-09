package studying.design_patterns.abstract_factory.factories;

import studying.design_patterns.abstract_factory.slider.GnomeSlider;
import studying.design_patterns.abstract_factory.slider.Slider;
import studying.design_patterns.abstract_factory.toggle.GnomeToggle;
import studying.design_patterns.abstract_factory.toggle.Toggle;

public class GnomeGuiFactory implements GuiFactory {

    @Override
    public Toggle createToggle() {
        return new GnomeToggle();
    }

    @Override
    public Slider createSlider() {
        return new GnomeSlider();
    }
}
