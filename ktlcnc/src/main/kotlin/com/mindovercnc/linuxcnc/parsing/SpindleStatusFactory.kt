package com.mindovercnc.linuxcnc.parsing

import com.mindovercnc.linuxcnc.model.SpindleStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import com.mindovercnc.linuxcnc.nml.Key
import java.nio.ByteBuffer

class SpindleStatusFactory(
    private val descriptor: BuffDescriptor
) : ParsingFactory<List<SpindleStatus>>(descriptor) {

    override fun parse(byteBuffer: ByteBuffer): List<SpindleStatus> {
        val numSpindles = byteBuffer.getIntForKey(Key.SpindlesCount)!!

        val spindle0Offset = descriptor.entries[Key.Spindle0]!!.startOffset
        val spindle1Offset = descriptor.entries[Key.Spindle1]!!.startOffset

        val result = mutableListOf<SpindleStatus>()
        for (spindleNo in 0 until numSpindles) {
            val spindleOffset = spindleNo * (spindle1Offset - spindle0Offset)

            result.add(
                SpindleStatus(
                    spindleRpm = byteBuffer.getDoubleForKey(Key.Spindle0Speed, spindleOffset)!!,
                    spindleScale = byteBuffer.getDoubleForKey(Key.Spindle0Scale, spindleOffset)!! * 100,
                    cssMaximum = byteBuffer.getDoubleForKey(Key.Spindle0CssMaximum, spindleOffset)!!,
                    cssFactor = byteBuffer.getDoubleForKey(Key.Spindle0CssFactor, spindleOffset)!!, //TODO: maybe *100
                    state = byteBuffer.getIntForKey(Key.Spindle0State, spindleOffset)!!,
                    direction = SpindleStatus.Direction.fromInt(byteBuffer.getIntForKey(Key.Spindle0Direction, spindleOffset)!!)!!,
                    increasing = SpindleStatus.Increasing.fromInt(byteBuffer.getIntForKey(Key.Spindle0Increasing, spindleOffset)!!)!!,
                    isBrakeEngaged = byteBuffer.getBooleanForKey(Key.Spindle0Brake, spindleOffset)!!,
                    isEnabled = byteBuffer.getBooleanForKey(Key.Spindle0Enabled, spindleOffset)!!,
                    isOverrideEnabled = byteBuffer.getBooleanForKey(Key.Spindle0OverrideEnabled, spindleOffset)!!,
                    isHomed = byteBuffer.getBooleanForKey(Key.Spindle0Homed, spindleOffset)!!,
                    orientState = byteBuffer.getIntForKey(Key.Spindle0OrientState, spindleOffset)!!,
                    orientFault = byteBuffer.getIntForKey(Key.Spindle0OrientFault, spindleOffset)!!
                )
            )
        }
        return result
    }
}