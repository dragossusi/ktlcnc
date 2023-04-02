# Kotlin LinuxCNC
Kotlin library to communicate with LinuxCNC using JNI.

## Setup

**Assuming you have linuxcnc installed**

### Variables

You need to define the paths first, in env variables or `gradle.properties` for genereting the jar.


| Env           | Property      | Description                |
|---------------|---------------|----------------------------|
| LINUXCNC_HOME | linuxcnc.home | The linuxcnc home folder   |
| LINUXCNC_JDK  | linuxcnc.jdk  | The jdk to be used for JNI |


Example using env(required for `make`):

```shell
export LINUXCNC_HOME=/path/to/linuxcnc
export LINUXCNC_JDK=/path/to/jdk
```

### Generating JNI files

```shell
cd ktlcnc/native
make
```

If you need to regenerate:
```shell
make clean
make
```

### Generating jar

```shell
./gradlew :ktlcnc:build
```

The jar will be located in:
`/ktlcnc/libs`