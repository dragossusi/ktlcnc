package com.mindovercnc.linuxcnc.nml

import java.util.*
import kotlin.collections.HashMap


class BuffDescriptorV29() : BuffDescriptor {
    private val map: MutableMap<Key, DecodingInfo> = EnumMap(Key::class.java)

    init {
        //Mapping for the fields of EMC_TASK_STAT
        map[Key.TaskMode] = DecodingInfo(212, DecodingInfo.DataType.Integer)
        map[Key.TaskState] = DecodingInfo(216, DecodingInfo.DataType.Integer)
        map[Key.ExecState] = DecodingInfo(220, DecodingInfo.DataType.Integer)
        map[Key.InterpreterState] = DecodingInfo(224, DecodingInfo.DataType.Integer)
        map[Key.SubroutineCallLevel] = DecodingInfo(228, DecodingInfo.DataType.Integer)
        map[Key.MotionLine] = DecodingInfo(232, DecodingInfo.DataType.Integer)
        map[Key.CurrentLine] = DecodingInfo(236, DecodingInfo.DataType.Integer)
        map[Key.ReadLine] = DecodingInfo(240, DecodingInfo.DataType.Integer)
        map[Key.IsOptionalStop] = DecodingInfo(244, DecodingInfo.DataType.Byte)
        map[Key.IsBlockDelete] = DecodingInfo(245, DecodingInfo.DataType.Byte)
        map[Key.IsDigitalInTimeout] = DecodingInfo(246, DecodingInfo.DataType.Byte)
        map[Key.LoadedFilePath] = DecodingInfo(247, DecodingInfo.DataType.String)
        map[Key.Command] = DecodingInfo(502, DecodingInfo.DataType.String)
        map[Key.G5xOffsetXStart] = DecodingInfo(760, DecodingInfo.DataType.Object)
        map[Key.G5xActiveIndex] = DecodingInfo(832, DecodingInfo.DataType.Integer)
        map[Key.G92OffsetXStart] = DecodingInfo(840, DecodingInfo.DataType.Object)
        map[Key.RotationXY] = DecodingInfo(912, DecodingInfo.DataType.Double)
        map[Key.ToolOffsetXStart] = DecodingInfo(920, DecodingInfo.DataType.Object)
        map[Key.ActiveGCodes] = DecodingInfo(992, DecodingInfo.DataType.Object)
        map[Key.ActiveMCodes] = DecodingInfo(1060, DecodingInfo.DataType.Object)
        map[Key.ActiveSettings] = DecodingInfo(1104, DecodingInfo.DataType.Object) //40 bytes -> 5 double values
        map[Key.ProgramUnits] = DecodingInfo(1144, DecodingInfo.DataType.Integer)
        map[Key.InterpreterErrorCode] = DecodingInfo(1148, DecodingInfo.DataType.Integer)
        map[Key.TaskPaused] = DecodingInfo(1152, DecodingInfo.DataType.Integer)
        map[Key.DelayLeft] = DecodingInfo(1160, DecodingInfo.DataType.Double)
        map[Key.QueuedMdiCommands] = DecodingInfo(1168, DecodingInfo.DataType.Integer)

        //Mapping for EMC_MOTION_STAT -> EMC_TRAJ_STAT
        map[Key.LinearUnits] = DecodingInfo(1392, DecodingInfo.DataType.Double)
        map[Key.AngularUnits] = DecodingInfo(1400, DecodingInfo.DataType.Double)
        map[Key.CycleTimeSeconds] = DecodingInfo(1408, DecodingInfo.DataType.Double)
        map[Key.JointsCount] = DecodingInfo(1416, DecodingInfo.DataType.Integer)
        map[Key.SpindlesCount] = DecodingInfo(1420, DecodingInfo.DataType.Integer)
        map[Key.AxisMask] = DecodingInfo(1428, DecodingInfo.DataType.Integer)
        map[Key.MotionMode] = DecodingInfo(1432, DecodingInfo.DataType.Integer)
        map[Key.IsEnabled] = DecodingInfo(1436, DecodingInfo.DataType.Byte)
        map[Key.IsInPosition] = DecodingInfo(1437, DecodingInfo.DataType.Byte)
        map[Key.PendingMotions] = DecodingInfo(1440, DecodingInfo.DataType.Integer)
        map[Key.ActiveMotions] = DecodingInfo(1444, DecodingInfo.DataType.Integer)
        map[Key.IsMotionQueueFull] = DecodingInfo(1448, DecodingInfo.DataType.Byte)
        map[Key.CurrentMotionId] = DecodingInfo(1452, DecodingInfo.DataType.Integer)
        map[Key.IsMotionPaused] = DecodingInfo(1456, DecodingInfo.DataType.Byte)
        map[Key.VelocityScaleFactor] = DecodingInfo(1464, DecodingInfo.DataType.Double)
        map[Key.RapidScaleFactor] = DecodingInfo(1472, DecodingInfo.DataType.Double)
        map[Key.CommandedPositionXStart] = DecodingInfo(1480, DecodingInfo.DataType.Object) // current commanded position
        map[Key.ActualPositionXStart] = DecodingInfo(1552, DecodingInfo.DataType.Object) // current actual position, from forward kins
        map[Key.SystemVelocity] = DecodingInfo(1624, DecodingInfo.DataType.Double)
        map[Key.SystemAcceleration] = DecodingInfo(1632, DecodingInfo.DataType.Double)
        map[Key.MaxVelocity] = DecodingInfo(1640, DecodingInfo.DataType.Double)
        map[Key.MaxAcceleration] = DecodingInfo(1648, DecodingInfo.DataType.Double)
        map[Key.ProbedPositionXStart] = DecodingInfo(1656, DecodingInfo.DataType.Object)
        map[Key.IsProbeTripped] = DecodingInfo(1728, DecodingInfo.DataType.Byte)
        map[Key.IsProbing] = DecodingInfo(1729, DecodingInfo.DataType.Byte)
        map[Key.ProbeInputValue] = DecodingInfo(1732, DecodingInfo.DataType.Integer)
        map[Key.KinematicsType] = DecodingInfo(1736, DecodingInfo.DataType.Integer)
        map[Key.MotionType] = DecodingInfo(1740, DecodingInfo.DataType.Integer)
        map[Key.CurrentMoveDtg] = DecodingInfo(1744, DecodingInfo.DataType.Double)
        map[Key.DtgPositionXStart] = DecodingInfo(1752, DecodingInfo.DataType.Object)
        map[Key.CurrentMoveVelocity] = DecodingInfo(1824, DecodingInfo.DataType.Double)
        map[Key.IsFeedOverrideEnabled] = DecodingInfo(1832, DecodingInfo.DataType.Byte)
        map[Key.IsAdaptiveFeedEnabled] = DecodingInfo(1833, DecodingInfo.DataType.Byte)
        map[Key.IsFeedHoldEnabled] = DecodingInfo(1834, DecodingInfo.DataType.Byte)

        map[Key.Joint0] = DecodingInfo(1912, DecodingInfo.DataType.Object)
        map[Key.Joint1] = DecodingInfo(2128, DecodingInfo.DataType.Object)

        map[Key.Joint0Type] = DecodingInfo(2020, DecodingInfo.DataType.Integer)
        map[Key.Joint0Units] = DecodingInfo(2024, DecodingInfo.DataType.Double)
        map[Key.Joint0Backlash] = DecodingInfo(2032, DecodingInfo.DataType.Double)
        map[Key.Joint0MinPositionLimit] = DecodingInfo(2040, DecodingInfo.DataType.Double)
        map[Key.Joint0MaxPositionLimit] = DecodingInfo(2048, DecodingInfo.DataType.Double)
        map[Key.Joint0MaxFollowingError] = DecodingInfo(2056, DecodingInfo.DataType.Double)
        map[Key.Joint0MinFollowingError] = DecodingInfo(2064, DecodingInfo.DataType.Double)
        map[Key.Joint0FollowingErrorCurrent] = DecodingInfo(2072, DecodingInfo.DataType.Double)
        map[Key.Joint0FollowingErrorHighMark] = DecodingInfo(2080, DecodingInfo.DataType.Double)
        map[Key.Joint0CommandedOutputPosition] = DecodingInfo(2088, DecodingInfo.DataType.Double)
        map[Key.Joint0CurrentInputPosition] = DecodingInfo(2096, DecodingInfo.DataType.Double)
        map[Key.Joint0CurrentVelocity] = DecodingInfo(2104, DecodingInfo.DataType.Double)
        map[Key.Joint0IsInPosition] = DecodingInfo(2112, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsHoming] = DecodingInfo(2113, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsHomed] = DecodingInfo(2114, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsFaulted] = DecodingInfo(2115, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsEnabled] = DecodingInfo(2116, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsMinSoftLimitReached] = DecodingInfo(2117, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsMaxSoftLimitReached] = DecodingInfo(2118, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsMinHardLimitReached] = DecodingInfo(2119, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsMaxHardLimitReached] = DecodingInfo(2120, DecodingInfo.DataType.Byte)
        map[Key.Joint0IsLimitOverrideOn] = DecodingInfo(2121, DecodingInfo.DataType.Byte)

        map[Key.Axis0] = DecodingInfo(5368, DecodingInfo.DataType.Object)
        map[Key.Axis1] = DecodingInfo(5504, DecodingInfo.DataType.Object)

        map[Key.Axis0MinPositionLimit] = DecodingInfo(5480, DecodingInfo.DataType.Double)
        map[Key.Axis0MaxPositionLimit] = DecodingInfo(5488, DecodingInfo.DataType.Double)
        map[Key.Axis0Velocity] = DecodingInfo(5496, DecodingInfo.DataType.Double)

        map[Key.Spindle0] = DecodingInfo(6592, DecodingInfo.DataType.Object)
        map[Key.Spindle1] = DecodingInfo(6760, DecodingInfo.DataType.Object)

        map[Key.Spindle0Speed] = DecodingInfo(6696, DecodingInfo.DataType.Double)
        map[Key.Spindle0Scale] = DecodingInfo(6704, DecodingInfo.DataType.Double)
        map[Key.Spindle0CssMaximum] = DecodingInfo(6712, DecodingInfo.DataType.Double)
        map[Key.Spindle0CssFactor] = DecodingInfo(6720, DecodingInfo.DataType.Double)
        map[Key.Spindle0State] = DecodingInfo(6728, DecodingInfo.DataType.Integer)
        map[Key.Spindle0Direction] = DecodingInfo(6732, DecodingInfo.DataType.Integer)
        map[Key.Spindle0Brake] = DecodingInfo(6736, DecodingInfo.DataType.Integer)
        map[Key.Spindle0Increasing] = DecodingInfo(6740, DecodingInfo.DataType.Integer)
        map[Key.Spindle0Enabled] = DecodingInfo(6744, DecodingInfo.DataType.Integer)
        map[Key.Spindle0OrientState] = DecodingInfo(6748, DecodingInfo.DataType.Integer)
        map[Key.Spindle0OrientFault] = DecodingInfo(6752, DecodingInfo.DataType.Integer)
        map[Key.Spindle0OverrideEnabled] = DecodingInfo(6756, DecodingInfo.DataType.Byte)
        map[Key.Spindle0Homed] = DecodingInfo(6757, DecodingInfo.DataType.Byte)

        map[Key.Motion64DigitalInputsInt] = DecodingInfo(7936, DecodingInfo.DataType.Object)
        map[Key.Motion64DigitalOutputsInt] = DecodingInfo(8192, DecodingInfo.DataType.Object)
        map[Key.Motion64AnalogInputsDouble] = DecodingInfo(8448, DecodingInfo.DataType.Object)
        map[Key.Motion64AnalogOutputsDouble] = DecodingInfo(8960, DecodingInfo.DataType.Object)

        map[Key.MotionDebug] = DecodingInfo(9728, DecodingInfo.DataType.Integer)
        map[Key.MotionOnSoftLimit] = DecodingInfo(9732, DecodingInfo.DataType.Integer)
        map[Key.ExternalOffsetsApplied] = DecodingInfo(9736, DecodingInfo.DataType.Integer)
        map[Key.ExternalOffsetsPositionXStart] = DecodingInfo(9744, DecodingInfo.DataType.Object)
        map[Key.NumExtraJoints] = DecodingInfo(9816, DecodingInfo.DataType.Integer)

        map[Key.IoCycleTime] = DecodingInfo(9936, DecodingInfo.DataType.Double)
        map[Key.IoDebug] = DecodingInfo(9944, DecodingInfo.DataType.Integer)
        map[Key.IoReason] = DecodingInfo(9948, DecodingInfo.DataType.Integer)
        map[Key.IoFaultDuringM6] = DecodingInfo(9952, DecodingInfo.DataType.Integer)

        map[Key.IoPocketPrepared] = DecodingInfo(10064, DecodingInfo.DataType.Integer)
        map[Key.IoLoadedTool] = DecodingInfo(10068, DecodingInfo.DataType.Integer)

        map[Key.IoCoolantMist] = DecodingInfo(10288, DecodingInfo.DataType.Integer)
        map[Key.IoCoolantFlood] = DecodingInfo(10292, DecodingInfo.DataType.Integer)

        map[Key.IoAuxEstop] = DecodingInfo(10400, DecodingInfo.DataType.Integer)
        map[Key.IoAuxLubeOn] = DecodingInfo(10512, DecodingInfo.DataType.Integer)
        map[Key.IoAuxLubeLevelOk] = DecodingInfo(10516, DecodingInfo.DataType.Integer)
    }

    override val entries: Map<Key, DecodingInfo>
        get() = map
}