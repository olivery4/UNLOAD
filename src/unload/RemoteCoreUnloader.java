package unload.blocks;

import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.blocks.distribution.Unloader;
import mindustry.world.meta.Env;

public class RemoteCoreUnloader extends Unloader {

    public RemoteCoreUnloader(String name) {
        super(name);
        envEnabled |= Env.client | Env.server;
        update = true;
        hasPower = true;
        configurable = true;
        solid = true;
    }

    public class RemoteCoreUnloaderBuild extends UnloaderBuild {

        @Override
        public void updateTile() {
            super.updateTile();

            if (!consValid() || !enabled) return;

            // Only pull from core if we have space
            if (items.total() < itemCapacity && power.status > 0.5f) {
                Item selected = this.config();
                if (selected == null) return;

                var core = team.core();
                if (core != null && core.items.has(selected, 1)) {
                    core.items.remove(selected, 1);
                    items.add(selected, 1);
                }
            }

            dump();
        }

        @Override
        public void draw() {
            super.draw();
        }

        @Override
        public boolean acceptItem(Building source, Item item) {
            // Block should not accept external items
            return false;
        }

        @Override
        public boolean outputsItems() {
            return true;
        }
    }
}
