package dsa_dp.design_patterns.adapter;

public interface Emulator {
    boolean StartGame(NintendoGame game);

    boolean QuitGame(NintendoGame game);

    boolean PauseGame(NintendoGame game);
}
