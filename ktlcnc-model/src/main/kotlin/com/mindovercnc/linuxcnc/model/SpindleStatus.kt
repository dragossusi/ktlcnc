package com.mindovercnc.linuxcnc.model

data class SpindleStatus(
    val spindleRpm: Double,
    val spindleScale: Double,
    val cssMaximum: Double,
    val cssFactor: Double,
    /**
     * Not sure what this represents
     */
    val state: Int,
    val direction: Direction,
    val increasing: Increasing,
    val isBrakeEngaged: Boolean,
    val isEnabled: Boolean,
    val isOverrideEnabled: Boolean,
    val isHomed: Boolean,
    /**
     * Not sure about possible values
     */
    val orientState: Int,
    /**
     * Not sure about possible values.
     */
    val orientFault: Int


) {
    enum class Direction(private val value: Int) {
        STOPPED(0),
        FORWARD(1),
        REVERSE(-1);

        companion object {
            private val map = values().associateBy(Direction::value)
            fun fromInt(value: Int) = map[value]
        }
    }

    enum class Increasing(private val value: Int) {
        NONE(0),
        INCREASING(1),
        DECREASING(-1);

        companion object {
            private val map = values().associateBy(Increasing::value)
            fun fromInt(value: Int) = map[value]
        }
    }
}
