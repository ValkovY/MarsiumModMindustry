package vm.content;

import arc.graphics.Color;
import arc.math.Mathf;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.content.Planets;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.maps.planet.*;

public class VMPlanets{

    public static Planet marsium;

    public static void load() {
        marsium = new Planet("marsium", Planets.sun, 1f, 3) {{
            generator = new ErekirPlanetGenerator();
            hasAtmosphere = true;
            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 4)
            );
            allowSectorInvasion = false;
            atmosphereColor = Color.valueOf("ffb02e");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            landCloudColor = Color.valueOf("#9f8170");
            orbitRadius = 60f;
            startSector = 3;
            accessible = true;
            alwaysUnlocked = true;
            bloom = false;
            orbitTime = Mathf.pow(orbitRadius, 1.5f) * 960;
            ruleSetter = r -> {
              r.waveTeam = Team.blue;
              r.attributes.set(Attribute.heat, -0.2f);
              r.showSpawns = true;
              r.coreCapture = true;
              r.coreIncinerates = false;
            };
        }};
    }
}
