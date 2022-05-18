package com.mindovercnc.linuxcnc.model

data class SpeedInfo(
    val rapidOverride: Double = 0.0,
    val feedOverride: Double = 0.0,
    val currentVelocity: Double = 0.0,
    val nominalFeed: Double = 0.0,
    val maxVelocity: Double = 0.0,
    val currentAcceleration: Double = 0.0,
    val maxAcceleration: Double = 0.0,
    val jogSpeed: Double = 0.0,
)