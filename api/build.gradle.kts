plugins {
    id("buildlogic.java-17")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
}

dependencies {
    compileOnly(libs.paper.get1().get9())
    compileOnly(libs.annotations)
}
