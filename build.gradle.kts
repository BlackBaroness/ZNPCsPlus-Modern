subprojects {
    version = "2.1.0-${System.getenv()["BUILD_ID"] ?: "DEV"}"
}
