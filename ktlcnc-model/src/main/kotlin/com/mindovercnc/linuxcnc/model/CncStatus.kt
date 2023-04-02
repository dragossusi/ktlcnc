package com.mindovercnc.linuxcnc.model

data class CncStatus(
    val taskStatus: TaskStatus,
    val motionStatus: MotionStatus,
    val ioStatus: IoStatus
){
}