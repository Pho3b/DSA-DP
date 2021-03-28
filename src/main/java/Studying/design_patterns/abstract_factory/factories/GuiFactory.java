package Studying.design_patterns.abstract_factory.factories;

import Studying.design_patterns.abstract_factory.slider.Slider;
import Studying.design_patterns.abstract_factory.toggle.Toggle;

public interface GuiFactory {
    Toggle createToggle();

    Slider createSlider();
}
