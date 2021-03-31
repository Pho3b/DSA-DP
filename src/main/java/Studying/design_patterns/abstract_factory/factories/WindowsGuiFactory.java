package Studying.design_patterns.abstract_factory.factories;

import Studying.design_patterns.abstract_factory.slider.Slider;
import Studying.design_patterns.abstract_factory.slider.WindowsSlider;
import Studying.design_patterns.abstract_factory.toggle.Toggle;
import Studying.design_patterns.abstract_factory.toggle.WindowsToggle;

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
