package dsa_dp.design_patterns.abstract_factory.factories;

import dsa_dp.design_patterns.abstract_factory.slider.Slider;
import dsa_dp.design_patterns.abstract_factory.toggle.Toggle;

public interface GuiFactory {
    Toggle createToggle();

    Slider createSlider();
}
