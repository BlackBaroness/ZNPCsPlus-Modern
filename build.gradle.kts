subprojects {
    version = "2.1.0" + if (System.getenv().containsKey("BUILD_ID")) "-SNAPSHOT" else ""
}
