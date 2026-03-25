import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("de.eldoria.plugin-yml.bukkit")
}

bukkit {
    name = "ZNPCsPlus"
    prefix = rootProject.name
    main = "lol.pyr.znpcsplus.ZNpcsPlusBootstrap"
    authors = listOf("Pyr", "D3v1s0m", "BlackBaroness")
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD

    depend = listOf(
        "packetevents"
    )

    softDepend = listOf(
        "PlaceholderAPI",
        "ServersNPC",
        "ProtocolLib",
        "ViaVersion",
        "ViaBackwards",
        "ViaRewind",
        "Geyser-Spigot"
    )

    loadBefore = listOf(
        "Quests"
    )

    commands {
        create("npc") {
            permission = "znpcsplus.command.npc"
            aliases = listOf("znpc", "znpcs", "npcs")
        }
    }
}
