package Studying.design_patterns.adapter;

public interface Emulator {
    boolean StartGame(NintendoGame game);

    boolean QuitGame(NintendoGame game);

    boolean PauseGame(NintendoGame game);
}
