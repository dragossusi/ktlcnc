import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

group = "ro.dragossusi"
version = Versions.app

kotlin {
    val paths = NativePaths.getNativePaths().joinToString(":")
    val argument = "-Djava.library.path=$paths"
    println(argument)
    kotlinDaemonJvmArgs = listOf(argument)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    api(project(":ktlcnc-model"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        publications.withType<MavenPublication> {
            pom {
                name.set("Kotlin LinuxCNC")
                description.set("LinuxCNC communication from kotlin")
            }
        }
    }
}

apply<PublishPlugin>()