package com.mindovercnc.linuxcnc

import java.io.File

object CncInitializer {

    private const val libName = "libLinuxCNC.so"

    operator fun invoke(destFolder: File): File {
        val destFile = File(destFolder, libName)
        if (!destFile.exists()) {
            println("Copy $libName to $destFolder")
            CncInitializer::class.java.classLoader
                .getResourceAsStream(libName).use {
                    it.copyTo(destFile.outputStream())
                }
        }
        //System.loadLibrary("linuxcncini");
        System.loadLibrary("nml")
        System.loadLibrary("linuxcnchal")
        System.load(destFile.absolutePath)
        return destFile
    }
}

fun main() {
    val file = CncInitializer.invoke(File("."))
    println(file)
}