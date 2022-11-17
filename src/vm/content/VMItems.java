package vm.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class VMItems {
	public static Item
		niobium;

    public static void load() {
        niobium = new Item("niobium", Color.valueOf("abcdef")) {{
            radioactivity = 0.70f;
            cost = 2;
            charge = 0.04f;
            hardness = 5;
            flammability = -0.10f;
        }};
    }
}
