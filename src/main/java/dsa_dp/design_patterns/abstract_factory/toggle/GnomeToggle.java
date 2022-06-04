package dsa_dp.design_patterns.abstract_factory.toggle;

public class GnomeToggle implements Toggle {

    @Override
    public String init() {
        return this.getClass().getSimpleName() + " initialized";
    }
}
