plugins {
    java
    id("com.gradleup.shadow")
}

tasks.jar {
    enabled = false
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    mergeServiceFiles()

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
