package com.mindovercnc.linuxcnc.model

/**
 * Types for motion control
 */
enum class MotionMode(val value: Int) {
    /**
     * Independent axis motion
     */
    MODE_FREE(1),

    /**
     * Coordinated axis motion
     */
    MODE_COORDINATED(2),

    /**
     * Velocity based world coordinates motion
     */
    MODE_TELEOP(3);

    companion object {
        private val map = values().associateBy(MotionMode::value)
        fun fromInt(type: Int) = map[type]
    }
}