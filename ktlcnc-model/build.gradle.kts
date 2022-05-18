import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    `maven-publish`
    signing
}

group = "ro.dragossusi"
version = Versions.app

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
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