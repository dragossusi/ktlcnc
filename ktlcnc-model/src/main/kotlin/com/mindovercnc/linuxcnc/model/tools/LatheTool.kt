package com.mindovercnc.linuxcnc.model.tools

sealed class LatheTool(
    open val toolId: Int?,
    open val tipOrientation: TipOrientation,
    open val spindleDirection: SpindleDirection,
    open val minutesUsed: Double
) {
    data class Turning(
        override val toolId: Int? = null,
        val insert: CuttingInsert,
        override val tipOrientation: TipOrientation,
        override val spindleDirection: SpindleDirection,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, tipOrientation, spindleDirection, minutesUsed)

    data class Boring(
        override val toolId: Int? = null,
        val insert: CuttingInsert,
        override val tipOrientation: TipOrientation,
        override val spindleDirection: SpindleDirection,
        val minBoreDiameter: Double,
        val maxZDepth: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, tipOrientation, spindleDirection, minutesUsed)

    data class DrillingReaming(
        override val toolId: Int? = null,
        val insert: CuttingInsert? = null,
        val toolDiameter: Double,
        val maxZDepth: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, TipOrientation.Position7, SpindleDirection.Reverse, minutesUsed)

    data class Parting(
        override val toolId: Int? = null,
        val insert: CuttingInsert,
        val bladeWidth: Double,
        val maxXDepth: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, TipOrientation.Position6, SpindleDirection.Reverse, minutesUsed)

    data class Grooving(
        override val toolId: Int? = null,
        val insert: CuttingInsert,
        override val tipOrientation: TipOrientation,
        override val spindleDirection: SpindleDirection,
        val bladeWidth: Double,
        val maxXDepth: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, tipOrientation, spindleDirection, minutesUsed)

    data class OdThreading(
        override val toolId: Int? = null,
        val insert: CuttingInsert,
        val minPitch: Double,
        val maxPitch: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, TipOrientation.Position6, SpindleDirection.Reverse, minutesUsed)

    data class IdThreading(
        override val toolId: Int? = null,
        val insert: CuttingInsert,
        val minPitch: Double,
        val maxPitch: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, TipOrientation.Position8, SpindleDirection.Reverse, minutesUsed)

    data class Slotting(
        override val toolId: Int? = null,
        val insert: CuttingInsert? = null,
        val bladeWidth: Double,
        val maxZDepth: Double,
        override val minutesUsed: Double = 0.0
    ) : LatheTool(toolId, TipOrientation.Position7, SpindleDirection.None, minutesUsed)
}
