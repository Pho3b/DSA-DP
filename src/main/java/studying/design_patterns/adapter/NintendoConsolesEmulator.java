package studying.design_patterns.adapter;

public class NintendoConsolesEmulator implements Emulator {

    public boolean StartGame(NintendoGame game) {
        game.Start();

        return true;
    }

    public boolean QuitGame(NintendoGame game) {
        game.Quit();

        return true;
    }

    public boolean PauseGame(NintendoGame game) {
        game.Pause();

        return true;
    }
}
