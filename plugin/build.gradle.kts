import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    java
    id("io.freefair.lombok") version "9.2.0"
    id("com.gradleup.shadow") version "9.4.0"
    id("de.eldoria.plugin-yml.bukkit") version "0.8.0"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
    maven("https://repo.extendedclip.com/releases/") // PlaceholderAPI
    maven("https://repo.codemc.io/repository/maven-releases/") // PacketEvents
    maven("https://repo.pyr.lol/releases") // Director
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:26.0.1")
    compileOnly("me.clip:placeholderapi:2.12.2")
    compileOnly("com.github.retrooper:packetevents-spigot:2.11.2")

    implementation(project(":api"))
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("org.bstats:bstats-bukkit:3.2.1")
    implementation("space.arim.dazzleconf:dazzleconf-ext-snakeyaml:1.4.0-M2")
    implementation("lol.pyr:director-adventure:2.1.2")

    implementation("net.kyori:adventure-platform-api:4.4.1") { isTransitive = false }
    implementation("net.kyori:adventure-platform-facet:4.4.1") { isTransitive = false }
    implementation("net.kyori:adventure-platform-bukkit:4.4.1") { isTransitive = false }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.release = 21
}

tasks.processResources {
    expand("version" to project.version)
}

tasks.jar {
    enabled = false
}

tasks.shadowJar {
    mergeServiceFiles()
    archiveFileName.set("${rootProject.name}.jar")

    manifest {
        System.getenv("GIT_BRANCH")?.also { attributes["Git-Branch"] = it }
        System.getenv("GIT_COMMIT")?.also { attributes["Git-Commit"] = it }
        System.getenv("BUILD_ID")?.also { attributes["Build-Id"] = it }
    }

    exclude(
        "META-INF/proguard/**",
        "META-INF/maven/**",
    )

    projectDir.resolve("relocations.txt").forEachLine {
        if (it.isNotBlank()) {
            relocate(it, "lol.pyr.znpcsplus.__relocated__.$it")
        }
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

bukkit {
    name = rootProject.name
    main = "lol.pyr.znpcsplus.ZNpcsPlusBootstrap"
    authors = listOf("Pyr", "D3v1s0m", "BlackBaroness")
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
    apiVersion = "1.19"
    foliaSupported = true

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
