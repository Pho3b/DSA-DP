package Studying.design_patterns.iterator.collections;

public class BugItem {
    private final String name;
    private final int rarity;
    private final boolean canFly;


    public BugItem(String name, int rarity, boolean canFly) {
        this.name = name;
        this.rarity = rarity;
        this.canFly = canFly;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public boolean canFly() {
        return canFly;
    }
}
