package unload;

import mindustry.mod.*;

public class ModMain extends Mod {
    @Override
    public void loadContent() {
        ModBlocks.load(); // Register your blocks
    }
}
