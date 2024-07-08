plugins {
    id("java")
}

group = "io.github.thatsmusic99"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://ci.pluginwiki.us/plugin/repository/everything/")
    maven("https://mvn.lumine.io/repository/maven-public/")
    maven("https://repo.oraxen.com/releases")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    compileOnly("com.arcaniax:HeadDatabase-API:1.3.1")
    compileOnly("io.th0rgal:oraxen:1.173.0")
    compileOnly("com.github.LoneDev6:API-ItemsAdder:3.5.0b")
    compileOnly("io.github.thatsmusic99:headsplus:7.1.1")
    compileOnly("io.lumine:Mythic-Dist:5.6.1")
    compileOnly("net.Indyuce:MMOItems:6.7.3")
    compileOnly("io.lumine:MythicLib-dist:1.4")

    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}