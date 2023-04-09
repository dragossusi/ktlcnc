package com.mindovercnc.linuxcnc.parsing

import ro.dragossusi.proto.linuxcnc.CncStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import ro.dragossusi.proto.linuxcnc.cncStatus
import java.nio.ByteBuffer

class CncStatusFactory(
    descriptor: BuffDescriptor,
    private val taskStatusFactory: TaskStatusFactory,
    private val motionStatusFactory: MotionStatusFactory,
    private val ioStatusFactory: IoStatusFactory
) : ParsingFactory<CncStatus>(descriptor) {

    override fun parse(byteBuffer: ByteBuffer) = cncStatus {
        taskStatus = taskStatusFactory.parse(byteBuffer)
        motionStatus = motionStatusFactory.parse(byteBuffer)
        ioStatus = ioStatusFactory.parse(byteBuffer)
    }
}

