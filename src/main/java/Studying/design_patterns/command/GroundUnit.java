package Studying.design_patterns.command;

public class GroundUnit {
    private final String[] weapons = new String[]{"sword", "bow", "spear"};
    private int currentWeapon = 0;


    public void switchWeapon() {
        String prevWeapon = weapons[currentWeapon];
        currentWeapon = (currentWeapon == 2 ? 0 : currentWeapon + 1);

        System.out.println("Current weapon switched from " + prevWeapon + " to " + weapons[currentWeapon]);
    }

    public void undoWeaponSwitch() {
        String prevWeapon = weapons[currentWeapon];
        currentWeapon = (currentWeapon <= 0 ? 2 : currentWeapon - 1);

        System.out.println("Current re set from " + prevWeapon + " to " + weapons[currentWeapon]);
    }

    public void moveToTarget() {
        System.out.println("Moved to the target");
    }

    public void turnBackFromTarget() {
        System.out.println("Turning back from target...");
    }

    public String getCurrentWeapon() {
        return this.weapons[currentWeapon];
    }
}
