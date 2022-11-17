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

    public static Planet marsium, extinction;

    public static void load() {
        marsium = new Planet("marsium", Planets.sun, 1f, 2) {{
            generator = new ErekirPlanetGenerator();
            hasAtmosphere = true;
            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 6)
            );
             cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 1, 0.15f, 0.14f, 5, Color.valueOf("#bc987e").a(0.75f), 2, 0.42f, 1f, 0.43f),
                new HexSkyMesh(this, 2, 0.6f, 0.15f, 5, Color.valueOf("#ea7e5d").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
            );
            allowSectorInvasion = false;
            atmosphereColor = Color.valueOf("c34d0a");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            landCloudColor = Color.valueOf("#c34d0a");
            orbitRadius = 90f;
            startSector = 10;
            accessible = true;
            alwaysUnlocked = true;
            bloom = false;
            orbitTime = Mathf.pow(orbitRadius, 1.5f) * 960;
            icon = "marsium";
            ruleSetter = r -> {
              r.waveTeam = Team.blue;
              r.attributes.set(Attribute.heat, -0.2f);
              r.showSpawns = true;
              r.coreCapture = true;
              r.coreIncinerates = false;
            };
        }};
        extinction = new Planet("extinction", marsium, 10f, 0) {{
            hasAtmosphere = false;
            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 4)
            );
            accessible = false;
            alwaysUnlocked = true;
            bloom = false;
        }};
    }
}
