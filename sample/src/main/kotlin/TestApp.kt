package com.mindovercnc.linuxcnc

import com.mindovercnc.linuxcnc.model.HalPin
import java.io.File
import kotlin.random.Random

fun main() {
    CncInitializer.invoke(File("."))
    val halHandler = HalHandler()
    try {
        val halComponent = halHandler.createComponent("WeilerE30 + ${Random.nextInt()}")
        println("Component created: $halComponent")
        halComponent?.let {
            val pinJoystickXPlus = it.addPin("Pin1", HalPin.Type.BIT, HalPin.Dir.IN) as? HalPin<Boolean>
            println("created $pinJoystickXPlus")
            val pinJoystickXMinus = it.addPin("Pin2", HalPin.Type.BIT, HalPin.Dir.IN) as? HalPin<Boolean>
            println("created $pinJoystickXMinus")
            it.setReady(it.componentId)
        }
    } catch (e: Exception) {
        println(e)
    }
}