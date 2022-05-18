package com.mindovercnc.linuxcnc.parsing

import com.mindovercnc.linuxcnc.model.MotionMode
import com.mindovercnc.linuxcnc.model.TrajectoryStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import com.mindovercnc.linuxcnc.nml.Key
import java.nio.ByteBuffer

class TrajectoryStatusFactory(
    descriptor: BuffDescriptor,
    private val positionFactory: PositionFactory,
) : ParsingFactory<TrajectoryStatus>(descriptor) {


    override fun parse(byteBuffer: ByteBuffer): TrajectoryStatus {
        return TrajectoryStatus(
            linearUnits = byteBuffer.getDoubleForKey(Key.LinearUnits)!!,
            angularUnits = byteBuffer.getDoubleForKey(Key.AngularUnits)!!,
            cycleTimeInSeconds = byteBuffer.getDoubleForKey(Key.CycleTimeSeconds)!!,
            numJoints = byteBuffer.getIntForKey(Key.JointsCount)!!,
            numSpindles = byteBuffer.getIntForKey(Key.SpindlesCount)!!,
            axisMask = byteBuffer.getIntForKey(Key.AxisMask)!!,
            motionMode = MotionMode.fromInt(byteBuffer.getIntForKey(Key.MotionMode)!!)!!,
            isEnabled = byteBuffer.getBooleanForKey(Key.IsEnabled)!!,
            isInPosition = byteBuffer.getBooleanForKey(Key.IsInPosition)!!,
            motionQueue = byteBuffer.getIntForKey(Key.PendingMotions)!!,
            activeQueue = byteBuffer.getIntForKey(Key.ActiveMotions)!!,
            isFullQueue = byteBuffer.getBooleanForKey(Key.IsMotionQueueFull)!!,
            currentMotionId = byteBuffer.getIntForKey(Key.CurrentMotionId)!!,
            isMotionPaused = byteBuffer.getBooleanForKey(Key.IsMotionPaused)!!,
            velocityScale = byteBuffer.getDoubleForKey(Key.VelocityScaleFactor)!! * 100,
            rapidScale = byteBuffer.getDoubleForKey(Key.RapidScaleFactor)!! * 100,
            currentCommandedPosition = positionFactory.parse(byteBuffer, PositionFactory.PositionType.CURRENT_COMMANDED),
            currentActualPosition = positionFactory.parse(byteBuffer, PositionFactory.PositionType.CURRENT_ACTUAL),
            systemVelocity = byteBuffer.getDoubleForKey(Key.SystemVelocity)!!,
            systemAcceleration = byteBuffer.getDoubleForKey(Key.SystemAcceleration)!!,
            maxVelocity = byteBuffer.getDoubleForKey(Key.MaxVelocity)!! * 60,
            maxAcceleration = byteBuffer.getDoubleForKey(Key.MaxAcceleration)!!,
            probedPosition = positionFactory.parse(byteBuffer, PositionFactory.PositionType.PROBED),
            isProbeTripped = byteBuffer.getBooleanForKey(Key.IsProbeTripped)!!,
            isProbingActive = byteBuffer.getBooleanForKey(Key.IsProbing)!!,
            probeValue = byteBuffer.getIntForKey(Key.ProbeInputValue)!!,
            kinematicsType = byteBuffer.getIntForKey(Key.KinematicsType)!!,
            motionType = byteBuffer.getIntForKey(Key.MotionType)!!,
            currentDistance2Go = byteBuffer.getDoubleForKey(Key.CurrentMoveDtg)!!,
            distance2Go = positionFactory.parse(byteBuffer, PositionFactory.PositionType.DTG),
            currentVelocity = byteBuffer.getDoubleForKey(Key.CurrentMoveVelocity)!! * 60,
            feedOverrideEnabled = byteBuffer.getBooleanForKey(Key.IsFeedOverrideEnabled)!!,
            adaptiveFeedEnabled = byteBuffer.getBooleanForKey(Key.IsAdaptiveFeedEnabled)!!,
            feedHoldEnabled = byteBuffer.getBooleanForKey(Key.IsFeedHoldEnabled)!!,
        )
    }
}