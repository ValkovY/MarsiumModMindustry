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
            color = noiseColor = Color.valueOf("F4A560");
            particleRegion = "particle";
            drawNoise = true;
            useWindVector = true;
            sizeMax = 100f;
            sizeMin = 25f;
            minAlpha = 0f;
            maxAlpha = 0.2f;
            density = 4000f;
            baseSpeed = 5f;
            attrs.set(Attribute.light, -0.3f);
            attrs.set(Attribute.water, -0.1f);
            opacityMultiplier = 0.35f;
            force = 0.7f;
            sound = Sounds.wind;
            soundVol = 0.8f;
            duration = 7f * Time.toMinutes;
        }};
    }
}
