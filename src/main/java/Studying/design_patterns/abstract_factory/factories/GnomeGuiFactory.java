package Studying.design_patterns.abstract_factory.factories;

import Studying.design_patterns.abstract_factory.slider.GnomeSlider;
import Studying.design_patterns.abstract_factory.slider.Slider;
import Studying.design_patterns.abstract_factory.toggle.GnomeToggle;
import Studying.design_patterns.abstract_factory.toggle.Toggle;

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
