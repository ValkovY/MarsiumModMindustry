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

    @Override
    public float getSizeScl(){
        //TODO should sectors be 600, or 500 blocks?
        return 2000 * 1.07f * 6f / 5f;
    }

    @Override
    public boolean allowLanding(Sector sector){
        //TODO disallowed for now
        return false;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    float rawTemp(Vec3 position){
        return position.dst(0, 0, 1)*2.2f - Simplex.noise3d(seed, 8, 0.54f, 1.4f, 10f + position.x, 10f + position.y, 10f + position.z) * 2.9f;
    }

    Block getBlock(Vec3 position){
        float ice = rawTemp(position);
        Tmp.v32.set(position);

        float height = rawHeight(position);
        Tmp.v31.set(position);
        height *= 1.2f;
        height = Mathf.clamp(height);

        Block result = terrain[Mathf.clamp((int)(height * terrain.length), 0, terrain.length - 1)];

        if(ice < 0.3 + Math.abs(Ridged.noise3d(seed + crystalSeed, position.x + 4f, position.y + 8f, position.z + 1f, crystalOct, crystalScl)) * crystalMag){
            return Blocks.crystallineStone;
        }

        if(ice < 0.6){
            if(result == Blocks.rhyolite || result == Blocks.yellowStone || result == Blocks.regolith){
                //TODO bio(?) luminescent stuff? ice?
                return Blocks.carbonStone; //TODO perhaps something else.
            }
        }

        position = Tmp.v32;

        //TODO tweak this to make it more natural
        //TODO edge distortion?
        if(ice < redThresh - noArkThresh && Ridged.noise3d(seed + arkSeed, position.x + 2f, position.y + 8f, position.z + 1f, arkOct, arkScl) > arkThresh){
            //TODO arkyic in middle
            result = Blocks.beryllicStone;
        }

        if(ice > redThresh){
            result = Blocks.redStone;
        }else if(ice > redThresh - 0.4f){
            //TODO this may increase the amount of regolith, but it's too obvious a transition.
            result = Blocks.regolith;
        }

        return result;
    }

    @Override
    public void genTile(Vec3 position, TileGen tile){
        tile.floor = getBlock(position);

        if(tile.floor == Blocks.rhyolite && rand.chance(0.01)){
            tile.floor = Blocks.rhyoliteCrater;
        }

        tile.block = tile.floor.asFloor().wall;

        if(Ridged.noise3d(seed + 1, position.x, position.y, position.z, 2, airScl) > airThresh){
            tile.block = Blocks.air;
        }

        //TODO only certain places should have carbon stone...
        if(Ridged.noise3d(seed + 2, position.x, position.y + 4f, position.z, 3, 6f) > 0.6){
            tile.floor = Blocks.carbonStone;
        }
    }
}
