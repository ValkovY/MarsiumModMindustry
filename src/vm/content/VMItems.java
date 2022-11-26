package vm.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class VMItems {
	public static Item
		niobium, redGround;
	
	public static final Seq<Item> marsiumItems = new Seq<>(), marsiumOnlyItems = new Seq<>();

	public static void load() {
        niobium = new Item("niobium", Color.valueOf("879aa1")) {{
            radioactivity = 0.70f;
            cost = 2;
            charge = 0.04f;
            hardness = 5;
            flammability = 0.01f;
        }};
	    
        redGround = new Item("red-ground", Color.valueOf("f4a460")) {{
            radioactivity = 0f;
            cost = 2;
            charge = 0f;
            hardness = 1;
            flammability = 0f;
        }};
		
	marsiumItems.addAll(
        niobium, redGround, tungsten
        );

        marsiumOnlyItems.addAll(marsiumItems).removeAll(serpuloItems).removeAll(erekirItems);

    }
}
