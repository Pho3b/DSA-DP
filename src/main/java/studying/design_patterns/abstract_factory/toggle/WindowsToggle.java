package studying.design_patterns.abstract_factory.toggle;

public class WindowsToggle implements Toggle {

    @Override
    public String init() {
        return this.getClass().getSimpleName() + " initialized";
    }
}
