plugins {
    java
    id("io.freefair.lombok")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.withType<JavaCompile>() {
    options.release = 17
}
