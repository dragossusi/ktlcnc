import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  id("com.google.protobuf")
  `maven-publish`
  signing
}

group = "ro.dragossusi"

version = Versions.app

repositories { mavenCentral() }

dependencies {
  protobuf(project(":protos"))

  implementation(Libs.Kotlinx.coroutines_core)
  api(Libs.Protobuf.proto_kotlin)
  testImplementation(kotlin("test"))
}

protobuf {
  protoc { artifact = "com.google.protobuf:protoc:${Versions.Protobuf.protobuf_kotlin}" }

  generateProtoTasks { all().forEach { it.builtins { id("kotlin") } } }
}

tasks.test { useJUnitPlatform() }

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }

publishing {
  publications {
    create<MavenPublication>("maven") { from(components["java"]) }
    publications.withType<MavenPublication> {
      pom {
        name.set("Kotlin LinuxCNC")
        description.set("LinuxCNC communication from kotlin")
      }
    }
  }
}

apply<PublishPlugin>()
