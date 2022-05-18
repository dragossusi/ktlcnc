package com.mindovercnc.linuxcnc.model.tools

data class ToolHolder(
    val holderNumber: Int,
    val type: ToolHolderType,
    val latheTool: LatheTool? = null,
    val clampingPosition: Int = 0,
    val xOffset: Double? = null,
    val zOffset: Double? = null,
)