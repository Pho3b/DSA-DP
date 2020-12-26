package Studying.design_patterns.adapter;

public class NintendoGame {
    String name;
    String consoleVersion = "Nintendo";


    public NintendoGame(String name) {
        this.name = name;
    }

    public void Start() {
        System.out.println("Starting the " + this.consoleVersion + " version of " + this.name);
    }

    public void Quit() {
        System.out.println("Quitting the " + this.consoleVersion + " version of " + this.name);
    }

    public void Pause() {
        System.out.println("Paused the " + this.consoleVersion + " version of " + this.name);
    }
}
