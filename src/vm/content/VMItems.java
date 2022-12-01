package vm.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class VMItems {
	public static Item
		niobium, molybdenum, redGround;
	
	public static final Seq<Item> marsiumItems = new Seq<>(), erekirItems = new Seq<>(), marsiumOnlyItems = new Seq<>();

	public static void load() {
        niobium = new Item("niobium", Color.valueOf("879aa1")) {{
            radioactivity = 0.70f;
            cost = 0.7;
            charge = 0.04f;
            hardness = 1;
            flammability = 0.01f;
        }};
	
	molybdenum = new Item("molybdenum", Color.valueOf("8c7ea6")) {{
            radioactivity = 0f;
            cost = 1.2;
            charge = 0f;
            hardness = 3;
            flammability = 0.15f;
        }};
	    
        redGround = new Item("red-ground", Color.valueOf("f4a460")) {{
            radioactivity = 0f;
            cost = 2;
            charge = 0f;
            hardness = 1;
            flammability = 0f;
        }};
		
	marsiumItems.addAll(
        niobium, redGround, molybdenum, Items.tungsten
        );

        marsiumOnlyItems.addAll(marsiumItems).removeAll(erekirItems);

    }
}
