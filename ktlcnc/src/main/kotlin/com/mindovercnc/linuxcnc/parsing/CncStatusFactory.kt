package com.mindovercnc.linuxcnc.parsing

import com.mindovercnc.linuxcnc.model.CncStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import java.nio.ByteBuffer

class CncStatusFactory(
    descriptor: BuffDescriptor,
    private val taskStatusFactory: TaskStatusFactory,
    private val motionStatusFactory: MotionStatusFactory,
    private val ioStatusFactory: IoStatusFactory
) : ParsingFactory<CncStatus>(descriptor) {

    override fun parse(byteBuffer: ByteBuffer) = CncStatus(
        taskStatus = taskStatusFactory.parse(byteBuffer),
        motionStatus = motionStatusFactory.parse(byteBuffer),
        ioStatus = ioStatusFactory.parse(byteBuffer),
    )
}

