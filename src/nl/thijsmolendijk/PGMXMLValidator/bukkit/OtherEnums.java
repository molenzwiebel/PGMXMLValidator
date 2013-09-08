package nl.thijsmolendijk.PGMXMLValidator.bukkit;

public class OtherEnums {
	public enum SpawnReason {

        /**
         * When something spawns from natural means
         */
        NATURAL,
        /**
         * When an entity spawns as a jockey of another entity (mostly spider jockeys)
         */
        JOCKEY,
        /**
         * When a creature spawns due to chunk generation
         */
        CHUNK_GEN,
        /**
         * When a creature spawns from a spawner
         */
        SPAWNER,
        /**
         * When a creature spawns from an egg
         */
        EGG,
        /**
         * When a creature spawns from a Spawner Egg
         */
        SPAWNER_EGG,
        /**
         * When a creature spawns because of a lightning strike
         */
        LIGHTNING,
        /**
         * When a creature is spawned by a player that is sleeping
         *
         * @deprecated No longer used
         */
        @Deprecated
        BED,
        /**
         * When a snowman is spawned by being built
         */
        BUILD_SNOWMAN,
        /**
         * When an iron golem is spawned by being built
         */
        BUILD_IRONGOLEM,
        /**
         * When a wither boss is spawned by being built
         */
        BUILD_WITHER,
        /**
         * When an iron golem is spawned to defend a village
         */
        VILLAGE_DEFENSE,
        /**
         * When a zombie is spawned to invade a village
         */
        VILLAGE_INVASION,
        /**
         * When an animal breeds to create a child
         */
        BREEDING,
        /**
         * When a slime splits
         */
        SLIME_SPLIT,
        /**
         * When a creature is spawned by plugins
         */
        CUSTOM,
        /**
         * When an entity is missing a SpawnReason
         */
        DEFAULT
    }
	public enum Environment {
        /**
         * Represents the "normal"/"surface world" map
         */
        NORMAL,
        /**
         * Represents a nether based map ("hell")
         */
        NETHER,
        /**
         * Represents the "end" map
         */
        THE_END;
	}
	public enum DamageCause {

        /**
         * Damage caused when an entity contacts a block such as a Cactus.
         * <p>
         * Damage: 1 (Cactus)
         */
        CONTACT,
        /**
         * Damage caused when an entity attacks another entity.
         * <p>
         * Damage: variable
         */
        ENTITY_ATTACK,
        /**
         * Damage caused when attacked by a projectile.
         * <p>
         * Damage: variable
         */
        PROJECTILE,
        /**
         * Damage caused by being put in a block
         * <p>
         * Damage: 1
         */
        SUFFOCATION,
        /**
         * Damage caused when an entity falls a distance greater than 3 blocks
         * <p>
         * Damage: fall height - 3.0
         */
        FALL,
        /**
         * Damage caused by direct exposure to fire
         * <p>
         * Damage: 1
         */
        FIRE,
        /**
         * Damage caused due to burns caused by fire
         * <p>
         * Damage: 1
         */
        FIRE_TICK,
        /**
         * Damage caused due to a snowman melting
         * <p>
         * Damage: 1
         */
        MELTING,
        /**
         * Damage caused by direct exposure to lava
         * <p>
         * Damage: 4
         */
        LAVA,
        /**
         * Damage caused by running out of air while in water
         * <p>
         * Damage: 2
         */
        DROWNING,
        /**
         * Damage caused by being in the area when a block explodes.
         * <p>
         * Damage: variable
         */
        BLOCK_EXPLOSION,
        /**
         * Damage caused by being in the area when an entity, such as a Creeper, explodes.
         * <p>
         * Damage: variable
         */
        ENTITY_EXPLOSION,
        /**
         * Damage caused by falling into the void
         * <p>
         * Damage: 4 for players
         */
        VOID,
        /**
         * Damage caused by being struck by lightning
         * <p>
         * Damage: 5
         */
        LIGHTNING,
        /**
         * Damage caused by committing suicide using the command "/kill"
         * <p>
         * Damage: 1000
         */
        SUICIDE,
        /**
         * Damage caused by starving due to having an empty hunger bar
         * <p>
         * Damage: 1
         */
        STARVATION,
        /**
         * Damage caused due to an ongoing poison effect
         * <p>
         * Damage: 1
         */
        POISON,
        /**
         * Damage caused by being hit by a damage potion or spell
         * <p>
         * Damage: variable
         */
        MAGIC,
        /**
         * Damage caused by Wither potion effect
         */
        WITHER,
        /**
         * Damage caused by being hit by a falling block which deals damage
         * <p>
         * <b>Note:</b> Not every block deals damage
         * <p>
         * Damage: variable
         */
        FALLING_BLOCK,
        /**
         * Damage caused in retaliation to another attack by the Thorns enchantment.
         * <p>
         * Damage: 1-4 (Thorns)
         */
        THORNS,
        /**
         * Custom damage.
         * <p>
         * Damage: variable
         */
        CUSTOM
    }
	public enum ChatColor {
	    /**
	     * Represents black
	     */
	    BLACK,
	    /**
	     * Represents dark blue
	     */
	    DARK_BLUE,
	    /**
	     * Represents dark green
	     */
	    DARK_GREEN,
	    /**
	     * Represents dark blue 
	     */
	    DARK_AQUA,
	    /**
	     * Represents dark red
	     */
	    DARK_RED,
	    /**
	     * Represents dark purple
	     */
	    DARK_PURPLE,
	    /**
	     * Represents gold
	     */
	    GOLD,
	    /**
	     * Represents gray
	     */
	    GRAY,
	    /**
	     * Represents dark gray
	     */
	    DARK_GRAY,
	    /**
	     * Represents blue
	     */
	    BLUE,
	    /**
	     * Represents green
	     */
	    GREEN,
	    /**
	     * Represents aqua
	     */
	    AQUA,
	    /**
	     * Represents red
	     */
	    RED,
	    /**
	     * Represents light purple
	     */
	    LIGHT_PURPLE,
	    /**
	     * Represents yellow
	     */
	    YELLOW,
	    /**
	     * Represents white
	     */
	    WHITE,
	    /**
	     * Represents magical characters that change around randomly
	     */
	    MAGIC,
	    /**
	     * Makes the text bold.
	     */
	    BOLD,
	    /**
	     * Makes a line appear through the text.
	     */
	    STRIKETHROUGH,
	    /**
	     * Makes the text appear underlined.
	     */
	    UNDERLINE,
	    /**
	     * Makes the text italic.
	     */
	    ITALIC,
	    /**
	     * Resets all previous chat colors or formats.
	     */
	    RESET;
	}
	public enum DyeColor {

	    /**
	     * Represents white dye
	     */
	    WHITE,
	    /**
	     * Represents orange dye
	     */
	    ORANGE,
	    /**
	     * Represents magenta dye
	     */
	    MAGENTA,
	    /**
	     * Represents light blue dye
	     */
	    LIGHT_BLUE,
	    /**
	     * Represents yellow dye
	     */
	    YELLOW,
	    /**
	     * Represents lime dye
	     */
	    LIME,
	    /**
	     * Represents pink dye
	     */
	    PINK,
	    /**
	     * Represents gray dye
	     */
	    GRAY,
	    /**
	     * Represents silver dye
	     */
	    SILVER,
	    /**
	     * Represents cyan dye
	     */
	    CYAN,
	    /**
	     * Represents purple dye
	     */
	    PURPLE,
	    /**
	     * Represents blue dye
	     */
	    BLUE,
	    /**
	     * Represents brown dye
	     */
	    BROWN,
	    /**
	     * Represents green dye
	     */
	    GREEN,
	    /**
	     * Represents red dye
	     */
	    RED,
	    /**
	     * Represents black dye
	     */
	    BLACK;
	}
}
