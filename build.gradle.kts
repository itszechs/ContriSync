plugins {
    kotlin("jvm") version "1.9.22"
    id("com.apollographql.apollo3") version "3.8.2"
}

group = "zechs.contri.sync"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.apollographql.apollo3:apollo-runtime:3.8.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "zechs.contri.sync.MainKt"
    }
}

apollo {
    service("service") {
        packageName.set("zechs.contri.sync")
    }
}