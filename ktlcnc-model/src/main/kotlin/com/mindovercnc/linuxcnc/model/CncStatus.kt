package com.mindovercnc.linuxcnc.model

data class CncStatus(
    val taskStatus: TaskStatus,
    val motionStatus: MotionStatus,
    val ioStatus: IoStatus
){
    val isSpindleOn
        get() = motionStatus.spindlesStatus[0].direction == SpindleStatus.Direction.REVERSE ||
                motionStatus.spindlesStatus[0].direction == SpindleStatus.Direction.FORWARD

    val isInMdiMode get() = taskStatus.taskMode == TaskMode.TaskModeMDI
    val isInManualMode get() = taskStatus.taskMode == TaskMode.TaskModeManual
    val isInAutoMode get() = taskStatus.taskMode == TaskMode.TaskModeAuto
}