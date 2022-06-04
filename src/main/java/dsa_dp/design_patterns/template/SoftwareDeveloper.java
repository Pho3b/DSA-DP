package dsa_dp.design_patterns.template;

public class SoftwareDeveloper extends Worker {
    private static final String wakeUpTime = "8:00 AM";

    @Override
    void wakeUp() {
        System.out.println("1. Waking up at " + wakeUpTime);
    }

    @Override
    void work() {
        System.out.println("4. Working on firmware today");
    }

    @Override
    public void goToGym() {
        System.out.println("Having a run on the tapis roulant at the gym");
    }
}
