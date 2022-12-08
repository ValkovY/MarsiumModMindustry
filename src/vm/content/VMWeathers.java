package vm.content;

import arc.graphics.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;
import mindustry.world.meta.*;

public class VMWeathers{
    public static Weather
    redSandstorm;

    public static void load(){
        redSandstorm = new ParticleWeather("redSandstorm"){{
            noiseColor = Color.valueOf("F4A560");
            particleRegion = "particle";
            drawNoise = true;
            useWindVector = true;
            sizeMax = 150f;
            sizeMin = 50f;
            minAlpha = 0f;
            maxAlpha = 0.2f;
            density = 2000f;
            baseSpeed = 7f;
            attrs.set(Attribute.light, -0.5f);
            attrs.set(Attribute.water, -0.5f);
            opacityMultiplier = 0.35f;
            force = 0.5f;
            sound = Sounds.wind;
            soundVol = 0.8f;
            duration = 7f * Time.toMinutes;
            statusGround = false;
        }};
    }
}
