plugins {
    java
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot API
    maven("https://repo.papermc.io/repository/maven-public/") // BungeeCord Chat API
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:26.1.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.release = 21
}
