package com.mindovercnc.linuxcnc.parsing

import com.mindovercnc.linuxcnc.model.JointStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import com.mindovercnc.linuxcnc.nml.Key
import java.nio.ByteBuffer

class JointStatusFactory(
    private val descriptor: BuffDescriptor
) : ParsingFactory<List<JointStatus>>(descriptor) {

    override fun parse(byteBuffer: ByteBuffer): List<JointStatus> {
        val numJoints = byteBuffer.getIntForKey(Key.JointsCount)!!

        val joint0Offset = descriptor.entries[Key.Joint0]!!.startOffset
        val joint1Offset = descriptor.entries[Key.Joint1]!!.startOffset

        val result = mutableListOf<JointStatus>()
        for (jointNo in 0 until numJoints) {
            val jointOffset = jointNo * (joint1Offset - joint0Offset)

            result.add(
                JointStatus(
                    jointType = byteBuffer.getBooleanForKey(Key.Joint0Type, jointOffset)!!,
                    units = byteBuffer.getDoubleForKey(Key.Joint0Units, jointOffset)!!,
                    backlash = byteBuffer.getDoubleForKey(Key.Joint0Backlash, jointOffset)!!,
                    minPositionLimit = byteBuffer.getDoubleForKey(Key.Joint0MinPositionLimit, jointOffset)!!,
                    maxPositionLimit = byteBuffer.getDoubleForKey(Key.Joint0MaxPositionLimit, jointOffset)!!,
                    minFollowingError = byteBuffer.getDoubleForKey(Key.Joint0MinFollowingError, jointOffset)!!,
                    maxFollowingError = byteBuffer.getDoubleForKey(Key.Joint0MaxFollowingError, jointOffset)!!,
                    currentFollowingError = byteBuffer.getDoubleForKey(Key.Joint0FollowingErrorCurrent, jointOffset)!!,
                    currentFollowingErrorHighMark = byteBuffer.getDoubleForKey(Key.Joint0FollowingErrorHighMark, jointOffset)!!,
                    commandedOutputPosition = byteBuffer.getDoubleForKey(Key.Joint0CommandedOutputPosition, jointOffset)!!,
                    currentInputPosition = byteBuffer.getDoubleForKey(Key.Joint0CurrentInputPosition, jointOffset)!!,
                    currentVelocity = byteBuffer.getDoubleForKey(Key.Joint0CurrentVelocity, jointOffset)!! * 60,
                    isInPosition = byteBuffer.getBooleanForKey(Key.Joint0IsInPosition, jointOffset)!!,
                    isHoming = byteBuffer.getBooleanForKey(Key.Joint0IsHoming, jointOffset)!!,
                    isHomed = byteBuffer.getBooleanForKey(Key.Joint0IsHomed, jointOffset)!!,
                    isAmpFault = byteBuffer.getBooleanForKey(Key.Joint0IsFaulted, jointOffset)!!,
                    isEnabled = byteBuffer.getBooleanForKey(Key.Joint0IsEnabled, jointOffset)!!,
                    minSoftLimitExceeded = byteBuffer.getBooleanForKey(Key.Joint0IsMinSoftLimitReached, jointOffset)!!,
                    maxSoftLimitExceeded = byteBuffer.getBooleanForKey(Key.Joint0IsMaxSoftLimitReached, jointOffset)!!,
                    minHardLimitExceeded = byteBuffer.getBooleanForKey(Key.Joint0IsMinHardLimitReached, jointOffset)!!,
                    maxHardLimitExceeded = byteBuffer.getBooleanForKey(Key.Joint0IsMaxHardLimitReached, jointOffset)!!,
                    isOverridingLimits = byteBuffer.getBooleanForKey(Key.Joint0IsLimitOverrideOn, jointOffset)!!,
                )
            )
        }
        return result
    }
}