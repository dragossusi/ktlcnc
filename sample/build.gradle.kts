import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { kotlin("jvm") }

group = "ro.dragossusi"

version = Versions.app

repositories { mavenCentral() }

dependencies {
  implementation(project(":ktlcnc"))
  testImplementation(kotlin("test"))
}

tasks.test { useJUnitPlatform() }

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }
