package Studying.design_patterns;

import Studying.design_patterns.template.Doctor;
import Studying.design_patterns.template.SoftwareDeveloper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemplateTest {
    SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper();
    Doctor doctor = new Doctor();

    /**
     * Not a real test case.
     * Using it as a showcase to show the template design pattern implementation.
     */
    @Test
    public void hookMethodImplementedTest() {
        softwareDeveloper.dailyRoutine();
        doctor.dailyRoutine();

        Assertions.assertTrue(true);
    }
}
