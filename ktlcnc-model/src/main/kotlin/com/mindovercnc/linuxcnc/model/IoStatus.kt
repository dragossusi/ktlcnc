package com.mindovercnc.linuxcnc.model

data class IoStatus(
    val cycleTime: Double,
    /**
     * Not sure what this is
     */
    val reason: Int,
    val isM6Fault: Boolean,
    val toolStatus: ToolStatus,
    val isMistOn: Boolean,
    val isFloodOn: Boolean,
    val isEstopActive: Boolean,
    val isLubePumpOn: Boolean,
    val isLubeLevelOk: Boolean
)
