package Studying.design_patterns.abstract_factory.slider;

public class GnomeSlider implements Slider {

    @Override
    public String init() {
        return this.getClass().getSimpleName() + " initialized";
    }
}
