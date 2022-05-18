package com.mindovercnc.linuxcnc.model

data class MotionStatus(
    val trajectoryStatus: TrajectoryStatus,
    val jointsStatus: List<JointStatus>,
    val axesStatus: List<AxisStatus>? = null,
    val spindlesStatus: List<SpindleStatus>,
    val synchronizedDigitalInputs: List<Int>,
    val synchronizedDigitalOutputs: List<Int>,
    val analogInputs: List<Double>,
    val analogOutputs: List<Double>,
    val isOnSoftLimit: Boolean,
    val isExternalOffsetsApplied: Boolean,
    val externalOffsets: Position,
    val numExtraJoints: Int
)