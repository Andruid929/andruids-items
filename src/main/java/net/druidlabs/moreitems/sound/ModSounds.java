package net.druidlabs.moreitems.sound;

import net.druidlabs.moreitems.MoreItems;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;

public class ModSounds {

    public static final SoundEvent HARMON_TUNE = registerSoundEvent("harmon_tune");
    public static final ResourceKey<JukeboxSong> HARMON_TUNE_KEY = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, "harmon_tune"));

    public static final SoundEvent YOKAI_TUNE = registerSoundEvent("yokai_tune");
    public static final ResourceKey<JukeboxSong> YOKAI_TUNE_KEY = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, "yokai_tune"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(MoreItems.MOD_ID, name);

        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        MoreItems.LOGGER.info("Registering Sounds for " + MoreItems.MOD_ID);
    }
}
