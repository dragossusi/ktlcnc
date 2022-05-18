package com.mindovercnc.linuxcnc.model

data class TrajectoryStatus(
    val linearUnits: Double,
    val angularUnits: Double,
    val cycleTimeInSeconds: Double,
    val numJoints: Int,
    val numSpindles: Int,
    val axisMask: Int,
    val motionMode: MotionMode,
    val isEnabled: Boolean,
    val isInPosition: Boolean,
    /**
     * Number of pending motions, counting current
     */
    val motionQueue: Int,
    /**
     * Number of motions blending
     */
    val activeQueue: Int,
    /**
     * When true, it cannot accept another motion.
     */
    val isFullQueue: Boolean,
    /**
     * The ID of currently executing motion.
     */
    val currentMotionId: Int,
    val isMotionPaused: Boolean,
    val velocityScale: Double,
    val rapidScale: Double,
    val currentCommandedPosition: Position,
    val currentActualPosition: Position,
    val systemVelocity: Double,
    val systemAcceleration: Double,
    val maxVelocity: Double,
    val maxAcceleration: Double,

    /**
     * Last position where the probe was tripped
     */
    val probedPosition: Position,
    /**
     * True if probe was tripped since last clear.
     */
    val isProbeTripped: Boolean,
    /**
     * True if currently waiting for probing signal.
     */
    val isProbingActive: Boolean,
    /**
     * Current value of probe input (might be boolean)
     */
    val probeValue: Int,

    /**
     * identity=1,serial=2,parallel=3,custom=4
     */
    val kinematicsType: Int,

    /**
     * Values not known yet
     */
    val motionType: Int,

    /**
     * In the current move.
     */
    val currentDistance2Go: Double,

    val distance2Go: Position,

    /**
     * In the current move.
     */
    val currentVelocity: Double,

    val feedOverrideEnabled: Boolean,

    val adaptiveFeedEnabled: Boolean,

    val feedHoldEnabled: Boolean
)