package Studying.design_patterns.adapter;

public interface Emulator {
    public boolean StartGame(NintendoGame game);

    public boolean QuitGame(NintendoGame game);

    public boolean PauseGame(NintendoGame game);
}
