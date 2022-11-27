package vm.content;

import mindustry.type.*;

import static vm.content.VMPlanets.*;

public class SectorPresets{
    public static SectorPreset
    marsiumTest;

    public static void load(){
        //region marsium

        marsiumTest = new SectorPreset("marsiumTest", marsium, 10){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 1;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};
    }
}
