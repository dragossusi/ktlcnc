package com.mindovercnc.linuxcnc.parsing

import com.mindovercnc.linuxcnc.model.MotionStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import com.mindovercnc.linuxcnc.nml.Key
import java.nio.ByteBuffer

private const val IO_NUMBER = 64

class MotionStatusFactory(
    descriptor: BuffDescriptor,
    private val trajectoryStatusFactory: TrajectoryStatusFactory,
    private val jointStatusFactory: JointStatusFactory,
    private val spindleStatusFactory: SpindleStatusFactory,
    private val positionFactory: PositionFactory,
) : ParsingFactory<MotionStatus>(descriptor) {

    override fun parse(byteBuffer: ByteBuffer): MotionStatus {
        return MotionStatus(
            trajectoryStatus = trajectoryStatusFactory.parse(byteBuffer),
            jointsStatus = jointStatusFactory.parse(byteBuffer),
            spindlesStatus = spindleStatusFactory.parse(byteBuffer),
            synchronizedDigitalInputs = parseDigitalIO(byteBuffer, Key.Motion64DigitalInputsInt),
            synchronizedDigitalOutputs = parseDigitalIO(byteBuffer, Key.Motion64DigitalOutputsInt),
            analogInputs = parseAnalogIO(byteBuffer, Key.Motion64AnalogInputsDouble),
            analogOutputs = parseAnalogIO(byteBuffer, Key.Motion64AnalogOutputsDouble),
            isOnSoftLimit = byteBuffer.getBooleanForKey(Key.MotionOnSoftLimit)!!,
            isExternalOffsetsApplied = byteBuffer.getBooleanForKey(Key.ExternalOffsetsApplied)!!,
            externalOffsets = positionFactory.parse(byteBuffer, PositionFactory.PositionType.EXTERNAL_OFFSETS),
            numExtraJoints = byteBuffer.getIntForKey(Key.NumExtraJoints)!!
        )
    }

    private fun parseDigitalIO(byteBuffer: ByteBuffer, key: Key): List<Int> {
        val result = mutableListOf<Int>()
        for (ioIndex in 0 until IO_NUMBER) {
            val offset = ioIndex * 4 // 4 bytes for int
            result.add(byteBuffer.getIntForKey(key, offset)!!)
        }
        return result
    }

    private fun parseAnalogIO(byteBuffer: ByteBuffer, key: Key): List<Double> {
        val result = mutableListOf<Double>()
        for (ioIndex in 0 until IO_NUMBER) {
            val offset = ioIndex * 8 // 8 bytes for double
            result.add(byteBuffer.getDoubleForKey(key, offset)!!)
        }
        return result
    }
}