package com.mindovercnc.linuxcnc.model

data class JointStatus(
    /**
     * EMC_JOINT_LINEAR, EMC_JOINT_ANGULAR
     */
    val jointType: Boolean,
    /**
     * Units per mm - linear, or degrees - angular
     */
    val units: Double,
    val backlash: Double,
    val minPositionLimit: Double,
    val maxPositionLimit: Double,
    val minFollowingError: Double,
    val maxFollowingError: Double,
    val currentFollowingError: Double,
    /**
     * Magnitude of max following error.
     */
    val currentFollowingErrorHighMark: Double,
    val commandedOutputPosition: Double,
    val currentInputPosition: Double,
    val currentVelocity: Double,
    val isInPosition: Boolean,
    val isHoming: Boolean,
    val isHomed: Boolean,
    val isAmpFault: Boolean,
    val isEnabled: Boolean,
    val minSoftLimitExceeded: Boolean,
    val maxSoftLimitExceeded: Boolean,
    val minHardLimitExceeded: Boolean,
    val maxHardLimitExceeded: Boolean,
    val isOverridingLimits: Boolean
)