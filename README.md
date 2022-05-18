# Kotlin LinuxCNC
Kotlin library to communicate with LinuxCNC using JNI.

## Setup

**Assuming you have linuxcnc installed**

### Env variables

You need to set some environment variables first:

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