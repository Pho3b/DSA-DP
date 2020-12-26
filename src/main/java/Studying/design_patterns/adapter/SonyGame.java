package Studying.design_patterns.adapter;

public class SonyGame {
    String name;
    String consoleVersion = "Sony";


    public SonyGame(String name) {
        this.name = name;
    }

    public void Start() {
        System.out.println("Starting the " + this.consoleVersion + " version of " + this.name);
    }

    public void Quit() {
        System.out.println("Quiting the " + this.consoleVersion + " version of " + this.name);
    }

    public void Pause() {
        System.out.println("Paused the " + this.consoleVersion + " version of " + this.name);
    }
}
