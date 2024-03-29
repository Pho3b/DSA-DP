package dsa_dp.design_patterns.abstract_factory.factories;

import dsa_dp.design_patterns.abstract_factory.slider.GnomeSlider;
import dsa_dp.design_patterns.abstract_factory.slider.Slider;
import dsa_dp.design_patterns.abstract_factory.toggle.GnomeToggle;
import dsa_dp.design_patterns.abstract_factory.toggle.Toggle;

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
