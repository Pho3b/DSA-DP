package Studying.design_patterns.template;

public class Doctor extends Worker {
    private static final String wakeUpTime = "7:30 AM";

    @Override
    void wakeUp() {
        System.out.println("1. Waking up at " + wakeUpTime);
    }

    @Override
    void work() {
        System.out.println("4. Visiting a patient");
    }
}
