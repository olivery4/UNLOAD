package unload;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import unload.blocks.RemoteCoreUnloader;

public class ModBlocks {
    public static Block remoteCoreUnloader;

    public static void load() {
        remoteCoreUnloader = new RemoteCoreUnloader("remote-core-unloader") {{
            size = 1;
            health = 1000;
            itemCapacity = 50;
            requirements(Category.distribution, with(Items.titanium, 50, Items.silicon, 40, Items.phase-fabric, 50));
            researchRequirements = with(
                Items.silicon, 10000,
                Items.titanium, 15000,
                Items.phase-fabric, 10000
            );
            consumesPower = true;
            consumePower(50f / 60f); // 50 power/sec
        }};
    }
}
