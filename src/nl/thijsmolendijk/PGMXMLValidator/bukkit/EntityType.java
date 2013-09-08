package nl.thijsmolendijk.PGMXMLValidator.bukkit;

public enum EntityType {
	// These strings MUST match the strings in nms.EntityTypes and are case sensitive.
    /**
     * An item resting on the ground.
     *
     * Spawn with {@link World#dropItem}
     * or {@link World#dropItemNaturally}
     */
    DROPPED_ITEM,
    /**
     * An experience orb.
     */
    EXPERIENCE_ORB,
    /**
     * A leash attached to a fencepost.
     */
    LEASH_HITCH,
    /**
     * A painting on a wall.
     */
    PAINTING,
    /**
     * An arrow projectile; may get stuck in the ground.
     */
    ARROW,
    /**
     * A flying snowball.
     */
    SNOWBALL,
    /**
     * A flying large fireball, as thrown by a Ghast for example.
     */
    FIREBALL,
    /**
     * A flying small fireball, such as thrown by a Blaze or player.
     */
    SMALL_FIREBALL,
    /**
     * A flying ender pearl.
     */
    ENDER_PEARL,
    /**
     * An ender eye signal.
     */
    ENDER_SIGNAL,
    /**
     * A flying experience bottle.
     */
    THROWN_EXP_BOTTLE,
    /**
     * An item frame on a wall.
     */
    ITEM_FRAME,
    /**
     * A flying wither skull projectile.
     */
    WITHER_SKULL,
    /**
     * Primed TNT that is about to explode.
     */
    PRIMED_TNT,
    /**
     * A block that is going to or is about to fall.
     */
    FALLING_BLOCK,
    FIREWORK,
    /**
     * A placed boat.
     */
    BOAT,
    /**
     * @see RideableMinecart
     */
    MINECART,
    /**
     * @see StorageMinecart
     */
    MINECART_CHEST,
    /**
     * @see PoweredMinecart
     */
    MINECART_FURNACE,
    /**
     * @see ExplosiveMinecart
     */
    MINECART_TNT,
    /**
     * @see HopperMinecart
     */
    MINECART_HOPPER,
    /**
     * @see SpawnerMinecart
     */
    MINECART_MOB_SPAWNER,
    CREEPER,
    SKELETON,
    SPIDER,
    GIANT,
    ZOMBIE,
    SLIME,
    GHAST,
    PIG_ZOMBIE,
    ENDERMAN,
    CAVE_SPIDER,
    SILVERFISH,
    BLAZE,
    MAGMA_CUBE,
    ENDER_DRAGON,
    WITHER,
    BAT,
    WITCH,
    PIG,
    SHEEP,
    COW,
    CHICKEN,
    SQUID,
    WOLF,
    MUSHROOM_COW,
    SNOWMAN,
    OCELOT,
    IRON_GOLEM,
    HORSE,
    VILLAGER,
    ENDER_CRYSTAL,
    // These don't have an entity ID in nms.EntityTypes.
    /**
     * A flying splash potion.
     */
    SPLASH_POTION,
    /**
     * A flying chicken egg.
     */
    EGG,
    /**
     * A fishing line and bobber.
     */
    FISHING_HOOK,
    /**
     * A bolt of lightning.
     *
     * Spawn with {@link World#strikeLightning}.
     */
    LIGHTNING,
    WEATHER,
    PLAYER,
    COMPLEX_PART,
    /**
     * An unknown entity without an Entity Class
     */
    UNKNOWN;
}
