package dsa_dp.design_patterns.abstract_factory.factories;

import dsa_dp.design_patterns.abstract_factory.slider.Slider;
import dsa_dp.design_patterns.abstract_factory.slider.WindowsSlider;
import dsa_dp.design_patterns.abstract_factory.toggle.Toggle;
import dsa_dp.design_patterns.abstract_factory.toggle.WindowsToggle;

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
