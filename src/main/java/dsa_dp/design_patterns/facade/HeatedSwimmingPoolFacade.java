package dsa_dp.design_patterns.facade;

import dsa_dp.design_patterns.implementations.facade_implementation.HeatingEngine;
import dsa_dp.design_patterns.implementations.facade_implementation.HydroMassageEngine;
import dsa_dp.design_patterns.implementations.facade_implementation.Light;

public class HeatedSwimmingPoolFacade {
    private final HydroMassageEngine hydroMassageEngine;
    private final Light light;
    private final HeatingEngine heatingEngine;


    public HeatedSwimmingPoolFacade(HydroMassageEngine hydroMassageEngine, Light light, HeatingEngine heatingEngine) {
        this.hydroMassageEngine = hydroMassageEngine;
        this.light = light;
        this.heatingEngine = heatingEngine;
    }

    /**
     * Examples of enclosing all the needed methods from the HeatedSwimmingPool ecosystem in a simpler
     * and more user friendly interface.
     */
    public void setRomanticAtmosphere() {
        this.hydroMassageEngine.turnOn();
        this.light.turnOn();
        this.heatingEngine.turnOn();
        this.hydroMassageEngine.setIntensity(5);
        this.light.setColor("purple");
        this.heatingEngine.setTemperature(35);

        System.out.println("Romantic atmosphere has been set");
    }

    public void activateMuscleReliefSetting() {
        this.hydroMassageEngine.turnOn();
        this.light.turnOn();
        this.heatingEngine.turnOn();
        this.hydroMassageEngine.setIntensity(50);
        this.light.setColor("white");
        this.heatingEngine.setTemperature(20);

        System.out.println("Muscle relief setting has been set");
    }
}
