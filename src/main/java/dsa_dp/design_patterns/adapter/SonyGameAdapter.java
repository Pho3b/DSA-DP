package dsa_dp.design_patterns.adapter;

/**
 * 'ADAPTER'
 * Here I want to make it possible to run a sony game on a NintendoConsoleEmulator.
 * 'Adapting' all the needed SonyGame methods to make it possible
 */
public class SonyGameAdapter extends NintendoGame {
    SonyGame sonyGame;


    public SonyGameAdapter(SonyGame sonyGame) {
        super(sonyGame.name);
        this.sonyGame = sonyGame;
    }

    @Override
    public void Start() {
        System.out.println("Starting the " + super.consoleVersion + " version of " + sonyGame.name);
    }

    @Override
    public void Quit() {
        System.out.println("Quitting the " + super.consoleVersion + " version of " + sonyGame.name);
    }

    @Override
    public void Pause() {
        System.out.println("Paused the " + super.consoleVersion + " version of " + sonyGame.name);
    }
}
