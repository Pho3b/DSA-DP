package Studying.design_patterns;

import Studying.design_patterns.adapter.NintendoConsolesEmulator;
import Studying.design_patterns.adapter.NintendoGame;
import Studying.design_patterns.adapter.SonyGame;
import Studying.design_patterns.adapter.SonyGameAdapter;
import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    public void workingWithoutTheAdapter() {
        NintendoConsolesEmulator nintendoEmulator = new NintendoConsolesEmulator();
        NintendoGame pikminGame = new NintendoGame("Pikmin");

        org.junit.Assert.assertTrue(nintendoEmulator.StartGame(pikminGame));
        org.junit.Assert.assertTrue(nintendoEmulator.QuitGame(pikminGame));
    }

    @Test
    public void workingWithTheAdapter() {
        NintendoConsolesEmulator nintendoEmulator = new NintendoConsolesEmulator();
        SonyGame metalGearSolid = new SonyGame("Metal Gear solid");
        SonyGameAdapter metalGearSolidAdapter = new SonyGameAdapter(metalGearSolid);

        org.junit.Assert.assertTrue(nintendoEmulator.StartGame(metalGearSolidAdapter));
        org.junit.Assert.assertTrue(nintendoEmulator.PauseGame(metalGearSolidAdapter));
        org.junit.Assert.assertTrue(nintendoEmulator.QuitGame(metalGearSolidAdapter));
    }
}
