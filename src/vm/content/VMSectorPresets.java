package vm.content;

import mindustry.type.*;

import static vm.content.VMPlanets.*;

public class VMSectorPresets{
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
            noLighting = false;
            startWaveTimeMultiplier = 3f;
        }};
    }
}
