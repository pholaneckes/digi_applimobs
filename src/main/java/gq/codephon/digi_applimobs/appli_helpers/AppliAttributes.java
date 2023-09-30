package gq.codephon.digi_applimobs.appli_helpers;

import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

public class AppliAttributes {
    public enum Attributes implements IStringSerializable{
        SOCIAL("social",(byte) 0),
        NAVI("navi",(byte) 1),
        GAME("game",(byte) 2),
        ENTERTAINMENT("entertainment",(byte) 3),
        LIFE("life",(byte) 4),
        TOOL("tool",(byte) 5),
        SYSTEM("system",(byte) 6),
        GOD("god",(byte) 7),
        OTHER("",(byte) 8);

        private final String name;
        private final byte id;

        Attributes(String name, byte id){
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public byte getId() {
            return this.id;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }
    }
}
