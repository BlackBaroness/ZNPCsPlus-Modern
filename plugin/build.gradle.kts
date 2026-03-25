plugins {
    id("buildlogic.java-17")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
    maven("https://repo.extendedclip.com/releases/") // PlaceholderAPI
    maven("https://repo.codemc.io/repository/maven-releases/") // PacketEvents
    maven("https://repo.pyr.lol/releases") // Director
}

dependencies {
    compileOnly(libs.paper.get1().get16())
    compileOnly(libs.annotations)
    compileOnly(libs.placeholderapi)
    compileOnly(libs.packetevents)

    implementation(projects.api)
    implementation(libs.gson)
    implementation(libs.bstats)
    implementation(libs.dazzleconf)
    implementation(libs.director)

    compileOnly(libs.minimessage) { isTransitive = false }
    implementation(libs.adventure.platform.api) { isTransitive = false }
    implementation(libs.adventure.platform.facet) { isTransitive = false }
    implementation(libs.adventure.platform.bukkit) { isTransitive = false }
}
