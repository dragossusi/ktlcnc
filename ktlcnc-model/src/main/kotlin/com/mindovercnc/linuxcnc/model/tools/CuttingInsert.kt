package com.mindovercnc.linuxcnc.model.tools

data class CuttingInsert(
    val id: Int? = null,
    val madeOf: MadeOf,
    val code: String,
    val tipRadius: Double,
    val frontAngle: Double,
    val backAngle: Double
)
