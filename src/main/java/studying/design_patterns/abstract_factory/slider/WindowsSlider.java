package studying.design_patterns.abstract_factory.slider;

public class WindowsSlider implements Slider {

    @Override
    public String init() {
        return this.getClass().getSimpleName() + " initialized";
    }
}
