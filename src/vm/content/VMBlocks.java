package vm.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;


import static vm.content.VMItems.*;
import static mindustry.type.ItemStack.*;

public class VMBlocks{
    public static Block

    //environment
    redSand, redGround,
      
    //ores
    oreNiobium, oreMolybdenum
    
    ;

    public static void load(){
      
        //region environment
      
        redSand = new Floor("red-sand"){{
           variants = 8;
           albedo = 0.9f;
           supportsOverlay = true;
        }};
        
        redGround = new Floor("red-ground"){{
           variants = 3;
           albedo = 0.9f;
        }};
      
        //region ores
      
        oreNiobium = new OreBlock(niobium){{
           variants = 3;
        }};
        oreMolybdenum = new OreBlock(molybdenum){{
           variants = 3;
        }};
    }
}
