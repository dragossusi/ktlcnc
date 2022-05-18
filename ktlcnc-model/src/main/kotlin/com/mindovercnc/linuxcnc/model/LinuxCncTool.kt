package com.mindovercnc.linuxcnc.model

import com.mindovercnc.linuxcnc.model.tools.TipOrientation

data class LinuxCncTool(
    val toolNo: Int,
    val pocket: Int = toolNo,
    val orientation: TipOrientation,
    val xOffset: Double,
    val zOffset: Double,
    val frontAngle: Double,
    val backAngle: Double,
    val tipRadius: Double,
    val comment: String
) {

    fun toFormattedString(): String {
        return "T$toolNo P$pocket X$xOffset Z$zOffset D$tipRadius I$frontAngle J$backAngle Q${orientation.orient} ;$comment"
    }

    class Builder {
        var toolNo: Int = 0
        var orientation: TipOrientation = TipOrientation.Position2
        var xOffset = 0.0
        var zOffset = 0.0
        var frontAngle = 0.0
        var backAngle = 0.0
        var tipRadius = 0.0
        var comment = ""

        fun build() = LinuxCncTool(
            toolNo = toolNo,
            orientation = orientation,
            xOffset = xOffset,
            zOffset = zOffset,
            frontAngle = frontAngle,
            backAngle = backAngle,
            tipRadius = tipRadius,
            comment = comment
        )
    }
}
