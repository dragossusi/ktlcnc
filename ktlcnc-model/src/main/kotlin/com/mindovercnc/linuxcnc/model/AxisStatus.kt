package com.mindovercnc.linuxcnc.model

data class AxisStatus(
    val minPositionLimit: Double,
    val maxPositionLimit: Double,
    val currentVelocity: Double
)