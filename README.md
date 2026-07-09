## ZNPCsPlus-Modern

A soft fork of [the original ZNPCsPlus](https://github.com/Pyrbu/ZNPCsPlus) with a few improvements:

- Designed for Paper 1.16+
- Uses a native Adventure API instead of its own wrapper
- Uses a shared PacketEvents instance instead of shading its own
  (you’ll need to install it manually: https://github.com/retrooper/packetevents/releases)
- Uses `api-version` 1.16 (or 1.18) instead of 1.13, so won't hurt performance because of legacy materials init
- Dependencies are updated to the latest versions
- Switched to a modern build setup (Kotlin DSL instead of Groovy, better plugins)
- Removed update checker

The goal of this fork is simple — modernize ZNPCsPlus without touching too much of the original code, so it stays as
stable as upstream.

> ⚠️ The plugin is still named **ZNPCsPlus**, so you can just replace the `.jar` without changing anything.

This repository is periodically synced with the upstream project.

---

# ZNPCsPlus [![](https://img.shields.io/discord/1099449144948555957?label=Discord&logo=Discord&style=plastic)](https://discord.gg/MAZz6XpPcg) [![](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fci.pyr.lol%2Fjob%2FZNPCsPlus%2F&style=plastic&logo=jenkins)](https://ci.pyr.lol/job/ZNPCsPlus/)

[![](https://img.shields.io/bstats/players/18244?style=plastic&label=bStats%20Players)]((https://bstats.org/plugin/bukkit/ZNPCsPlus/18244/)) [![](https://img.shields.io/bstats/servers/18244?style=plastic&label=bStats%20Servers)]((https://bstats.org/plugin/bukkit/ZNPCsPlus/18244/)) [![](https://img.shields.io/spiget/downloads/109380?style=plastic&label=Spigot%20Downloads)]((https://www.spigotmc.org/resources/znpcsplus.109380/))

[ZNPCsPlus](https://www.spigotmc.org/resources/znpcsplus.109380/) is a Spigot plugin that is used to create fake
entities
that players can interact with to perform actions like switching servers on a network or executing commands.

This plugin is a remake of a plugin called ZNPCs, we originally started because the maintainer of ZNPCs decided to
announce that he was
[dropping support for the plugin](https://github.com/Pyrbu/ZNPCsPlus/blob/2.X/.github/znpc.png?raw=true).

Looking for up-to-date builds of the plugin? Check out our [Jenkins](https://ci.pyr.lol/job/ZNPCsPlus/)

## Why is it so good?

- 100% Packet Based - Nothing is ran on the main thread
- Performance & stability oriented code
- Support for all versions from 1.8 to 26.2
- Support for multiple different storage options
- Intuitive command system

### Requirements, Extensions & Supported Software

Requirements:

- Java 8+
- Minecraft 1.8 - 26.2

Supported Softwares:

- Spigot ([Website](https://www.spigotmc.org/))
- Paper ([Github](https://github.com/PaperMC/Paper)) ([Website](https://papermc.io/software/paper))
- Folia ([Github](https://github.com/PaperMC/Folia)) ([Website](https://papermc.io/software/folia))
- ArcLight ([Github](https://github.com/IzzelAliz/Arclight))

Optional Dependencies/Extensions:

- PlaceholderAPI

## Found a bug?

Open an issue in the GitHub [issue tracker](https://github.com/Pyrbu/ZNPCsPlus/issues) or join
our [support discord](https://discord.gg/MAZz6XpPcg)

## BStats

[![](https://bstats.org/signatures/bukkit/znpcsplus.svg)](https://bstats.org/plugin/bukkit/ZNPCsPlus/18244/)

#### Like what you see? Want the project to continue improving? Consider starring the repository & leaving a positive review on [Spigot](https://www.spigotmc.org/resources/znpcsplus.109380/)!

## Credits

- [PacketEvents 2.0](https://github.com/retrooper/packetevents) - Packet library
- [Minecraft Wiki Protocol (formally wiki.vg)](https://minecraft.wiki/w/Minecraft_Wiki:Projects/wiki.vg_merge/Main_Page) -
  Minecraft protocol documentation
- [gson](https://github.com/google/gson) - JSON parsing library made by Google
- [Mineskin.org](https://mineskin.org/) - Website for raw skin file uploads
- [adventure](https://docs.advntr.dev/) - Minecraft text api
- [DazzleConf](https://github.com/A248/DazzleConf) - Configuration library
- [Director](https://github.com/Pyrbu/Director) - Command library
- [PlaceholderAPI](https://github.com/PlaceholderAPI/PlaceholderAPI) - Universal string placeholder library
