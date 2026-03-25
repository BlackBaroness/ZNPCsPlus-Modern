plugins {
    id("buildlogic.java-17")
    id("buildlogic.fatjar")
    id("buildlogic.plugin-yml")
    alias(libs.plugins.runTask.paper)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
    maven("https://repo.extendedclip.com/releases/") // PlaceholderAPI
    maven("https://repo.codemc.io/repository/maven-releases/") // PacketEvents
    maven("https://repo.pyr.lol/releases") // Director
}

dependencies {
    compileOnly(libs.paper.get1().get18())
    implementation(projects.plugin)
}

tasks.shadowJar {
    archiveFileName = "${rootProject.name}-1_18.jar"
}

bukkit {
    apiVersion = "1.18"
    foliaSupported = true
}

tasks.runServer {
    minecraftVersion("1.18.2")

    downloadPlugins {
        modrinth("packetevents", "2.11.2+spigot")
    }

    jvmArgs = jvmArgs.plus(
        arrayOf(
            "-DIReallyKnowWhatIAmDoingISwear",
            "-DPaper.IgnoreJavaVersion=true",
            "-Dcom.mojang.eula.agree=true",
            "-Dfile.encoding=UTF-8",
        )
    )
}
