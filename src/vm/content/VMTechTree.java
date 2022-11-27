package vm.content;

import arc.struct.*;
import arc.util.*;
import mindustry.entities.bullet.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;
import static vm.content.VMItems.*;
import static vm.content.VMPlanets.*;

public class VMTechTree{

    public static void load(){
        marsium.techTree = nodeRoot("marsium", coreBastion, () -> {
            nodeProduce(niobium, () -> {
            });
            nodeProduce(redGround, () -> {
            });
        });
    }
}
