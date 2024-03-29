package dsa_dp.design_patterns;

import dsa_dp.design_patterns.adapter.NintendoConsolesEmulator;
import dsa_dp.design_patterns.adapter.NintendoGame;
import dsa_dp.design_patterns.adapter.SonyGame;
import dsa_dp.design_patterns.adapter.SonyGameAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    public void workingWithoutTheAdapter() {
        NintendoConsolesEmulator nintendoEmulator = new NintendoConsolesEmulator();
        NintendoGame pikminGame = new NintendoGame("Pikmin");

        Assertions.assertTrue(nintendoEmulator.StartGame(pikminGame));
        Assertions.assertTrue(nintendoEmulator.QuitGame(pikminGame));
    }

    @Test
    public void workingWithTheAdapter() {
        NintendoConsolesEmulator nintendoEmulator = new NintendoConsolesEmulator();
        SonyGame metalGearSolid = new SonyGame("Metal Gear solid");
        SonyGameAdapter metalGearSolidAdapter = new SonyGameAdapter(metalGearSolid);

        Assertions.assertTrue(nintendoEmulator.StartGame(metalGearSolidAdapter));
        Assertions.assertTrue(nintendoEmulator.PauseGame(metalGearSolidAdapter));
        Assertions.assertTrue(nintendoEmulator.QuitGame(metalGearSolidAdapter));
    }
}
