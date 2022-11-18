package vm.planets;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.noise.*;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.generators.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;

import static mindustry.Vars.*;
import static mindustry.content.Blocks.*;

public class MarsiumPlanetGenerator extends PlanetGenerator{
    
    static final int seed = 100;

    BaseGenerator basegen = new BaseGenerator();
    float scl = 5f;
    float oceansOffset = 0.04f;

    //^ EQUATOR
    //                  <- LOW                   HIGH ->
    Block[][] arr =
            {
                    {Blocks.iceSnow, Blocks.ice, Blocks.ice, Blocks.snow, Blocks.ice, Blocks.redIce, Blocks.redIce, redStone, Blocks.redIce, Blocks.ice},
                    {Blocks.redIce, Blocks.redIce, Blocks.ice, Blocks.redStone, Blocks.redIce, Blocks.redIce, Blocks.redIce, Blocks.redStone, Blocks.redIce, Blocks.redIce},
                    {Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.sand},
                    {Blocks.sand, Blocks.sand, Blocks.redStone, Blocks.sand, Blocks.slag, Blocks.slag, Blocks.slag, Blocks.redStone, Blocks.sand, Blocks.sand},
                    {Blocks.sand, Blocks.sand, Blocks.slag, Blocks.slag, Blocks.slag, Blocks.slag, Blocks.slag, Blocks.sand, Blocks.sand, Blocks.sand},
                    {Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.slag, Blocks.slag, Blocks.slag, Blocks.slag, Blocks.sand, Blocks.sand},
                    {Blocks.sand, Blocks.rhyolite, Blocks.sand, Blocks.redStone, Blocks.slag, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand},
                    {Blocks.rhyolite, Blocks.rhyolite, Blocks.redStone, Blocks.redStone, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.rhyolite, Blocks.sand},
                    {Blocks.rhyolite, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.sand, Blocks.sand, Blocks.rhyolite, Blocks.rhyolite, Blocks.rhyolite},
                    {Blocks.redStone, Blocks.redStone, Blocks.redIce, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.rhyolite, Blocks.rhyolite, Blocks.rhyolite},
                    {Blocks.redStone, Blocks.redIce, Blocks.ice, Blocks.redIce, Blocks.redStone, Blocks.redStone, Blocks.redStone, Blocks.redIce, Blocks.redStone, Blocks.redStone},
                    {Blocks.ice, Blocks.iceSnow, Blocks.iceSnow, Blocks.snow, Blocks.snow, Blocks.redIce, Blocks.redIce, Blocks.redIce, Blocks.redIce, Blocks.redStone},
                    {Blocks.snow, Blocks.ice, Blocks.iceSnow, Blocks.snow, Blocks.snow, Blocks.snow, Blocks.ice, Blocks.redIce, Blocks.redIce, Blocks.redIce}
            };
            
       @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    @Override
    public Color getColor(Vec3 position){
        Block block = getBlock(position);

        //more obvious color
        if(block == Blocks.crystallineStone) block = Blocks.crystalFloor;
        //TODO this might be too green
        //if(block == Blocks.beryllicStone) block = Blocks.arkyicStone;

        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
}
