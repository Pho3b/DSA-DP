package Studying.design_patterns;

import Studying.design_patterns.facade.HeatedSwimmingPoolFacade;
import Studying.design_patterns.implementations.facade_implementation.HeatingEngine;
import Studying.design_patterns.implementations.facade_implementation.HydroMassageEngine;
import Studying.design_patterns.implementations.facade_implementation.Light;
import org.junit.jupiter.api.Test;

public class FacadeTest {
    // Instantiating single components
    HydroMassageEngine hydroMassageEngine = new HydroMassageEngine();
    Light light = new Light();
    HeatingEngine heatingEngine = new HeatingEngine();

    // Instantiating the Facade
    HeatedSwimmingPoolFacade heatedSwimmingPoolFacade = new HeatedSwimmingPoolFacade(hydroMassageEngine, light, heatingEngine);

    @Test
    public void correctRomanticSettingsTest() {
        heatedSwimmingPoolFacade.setRomanticAtmosphere();
        org.junit.Assert.assertEquals(hydroMassageEngine.getIntensityValue(), 5);
        org.junit.Assert.assertEquals(light.getLightColor(), "purple");
    }

    @Test
    public void correctMuscleReliefSettingsTest() {
        heatedSwimmingPoolFacade.activateMuscleReliefSetting();
        org.junit.Assert.assertEquals(hydroMassageEngine.getIntensityValue(), 50);
        org.junit.Assert.assertEquals(heatingEngine.getTemperature(), 20);
    }
}
