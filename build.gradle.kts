buildscript { repositories { mavenCentral() } }

plugins {
  kotlin("jvm") version Versions.kotlin apply false
  id("com.google.protobuf") version Versions.Protobuf.plugin apply false
}
