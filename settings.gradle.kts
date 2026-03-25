plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ZNPCsPlus-Modern"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    "api",
    "plugin",
    "plugin-1_16",
    "plugin-1_18",
)
