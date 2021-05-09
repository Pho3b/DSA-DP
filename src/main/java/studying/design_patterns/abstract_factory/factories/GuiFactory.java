package studying.design_patterns.abstract_factory.factories;

import studying.design_patterns.abstract_factory.slider.Slider;
import studying.design_patterns.abstract_factory.toggle.Toggle;

public interface GuiFactory {
    Toggle createToggle();

    Slider createSlider();
}
