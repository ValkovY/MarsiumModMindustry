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

public class MarsiumModGenerator extends PlanetGenerator {
    //alternate, less direct generation (wip)
    public static boolean alt = false;
    static final int seed = 1;
    final Color borudaMidColor = new Color();

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
}