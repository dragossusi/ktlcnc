package com.mindovercnc.linuxcnc.nml

/**
 * The text description of the keys must match the keys that are being output by running
 * ./DumpBufDesc If the keys do match, we can check the offsets of a linuxcnc versions to make sure
 * they are correct.
 */
enum class Key(val textDescription: String) {
  TaskMode("task.mode"),
  TaskState("task.state"),
  ExecState("task.execState"),
  InterpreterState("task.interpreterState"),
  SubroutineCallLevel("task.callLevel"),
  MotionLine("task.motionLine"),
  CurrentLine("task.currentLine"),
  ReadLine("task.readLine"),
  IsOptionalStop("task.isOptionalStop"),
  IsBlockDelete("task.isBlockDelete"),
  IsDigitalInTimeout("task.isDigitalInputTimeout"),
  LoadedFilePath("task.loadedFilePath"),
  Command("task.command"),
  G5xOffsetXStart("task.g5xOffsetXStart"),
  G5xActiveIndex("task.g5xActiveIndex"),
  G92OffsetXStart("task.g92OffsetXStart"),
  RotationXY("task.rotationXY"),
  ToolOffsetXStart("task.toolOffsetXStart"),
  ActiveGCodes("task.activeGCodes"),
  ActiveMCodes("task.activeMCodes"),
  ActiveSettings("task.activeSettings"),
  ProgramUnits("task.programUnits"),
  InterpreterErrorCode("task.interpreterErrorCode"),
  TaskPaused("task.taskPaused"),
  DelayLeft("task.delayLeft"),
  QueuedMdiCommands("task.queuedMdiCommands"),
  LinearUnits("motion.traj.linearUnits"),
  AngularUnits("motion.traj.angularUnits"),
  CycleTimeSeconds("motion.traj.cycleTimeSec"),
  JointsCount("motion.traj.jointsCount"),
  SpindlesCount("motion.traj.spindlesCount"),
  AxisMask("motion.traj.axisMask"),
  MotionMode("motion.traj.motionMode"),
  IsEnabled("motion.traj.isEnabled"),
  IsInPosition("motion.traj.isInPosition"),
  PendingMotions("motion.traj.pendingMotions"),
  ActiveMotions("motion.traj.activeMotions"),
  IsMotionQueueFull("motion.traj.isMotionQueueFull"),
  CurrentMotionId("motion.traj.currentMotionId"),
  IsMotionPaused("motion.traj.isMotionPaused"),
  VelocityScaleFactor("motion.traj.velocityScaleFactor"),
  RapidScaleFactor("motion.traj.rapidScaleFactor"),
  CommandedPositionXStart("motion.traj.cmdPosXStart"),
  ActualPositionXStart("motion.traj.actualPosXStart"),
  SystemVelocity("motion.traj.systemVelocity"),
  SystemAcceleration("motion.traj.systemAcceleration"),
  MaxVelocity("motion.traj.maxVelocity"),
  MaxAcceleration("motion.traj.maxAcceleration"),
  ProbedPositionXStart("motion.traj.probedPosXStart"),
  IsProbeTripped("motion.traj.isProbeTripped"),
  IsProbing("motion.traj.isProbing"),
  ProbeInputValue("motion.traj.probeInputValue"),

  /** identity=1,serial=2,parallel=3,custom=4 */
  KinematicsType("motion.traj.kinematicsType"),
  MotionType("motion.traj.motionType"),
  CurrentMoveDtg("motion.traj.currentMoveDtg"),
  DtgPositionXStart("motion.traj.dtgXStart"),
  CurrentMoveVelocity("motion.traj.currentMoveVelocity"),
  IsFeedOverrideEnabled("motion.traj.isFeedOverrideEnabled"),
  IsAdaptiveFeedEnabled("motion.traj.isAdaptiveFeedEnabled"),
  IsFeedHoldEnabled("motion.traj.isFeedHoldEnabled"),
  Joint0("motion.joint0"),
  Joint1("motion.joint1"),
  Joint0Type("motion.joint0.jointType"),
  Joint0Units("motion.joint0.units"),
  Joint0Backlash("motion.joint0.backlash"),
  Joint0MinPositionLimit("motion.joint0.minPositionLimit"),
  Joint0MaxPositionLimit("motion.joint0.maxPositionLimit"),
  Joint0MaxFollowingError("motion.joint0.maxFollowingError"),
  Joint0MinFollowingError("motion.joint0.minFollowingError"),
  Joint0FollowingErrorCurrent("motion.joint0.followingErrorCurrent"),
  Joint0FollowingErrorHighMark("motion.joint0.followingErrorHighMark"),
  Joint0CommandedOutputPosition("motion.joint0.output"),
  Joint0CurrentInputPosition("motion.joint0.input"),
  Joint0CurrentVelocity("motion.joint0.velocity"),
  Joint0IsInPosition("motion.joint0.inPosition"),
  Joint0IsHoming("motion.joint0.homing"),
  Joint0IsHomed("motion.joint0.homed"),
  Joint0IsFaulted("motion.joint0.fault"),
  Joint0IsEnabled("motion.joint0.enabled"),
  Joint0IsMinSoftLimitReached("motion.joint0.minSoftLimit"),
  Joint0IsMaxSoftLimitReached("motion.joint0.maxSoftLimit"),
  Joint0IsMinHardLimitReached("motion.joint0.minHardLimit"),
  Joint0IsMaxHardLimitReached("motion.joint0.maxHardLimit"),
  Joint0IsLimitOverrideOn("motion.joint0.overrideLimits"),
  Axis0("motion.axis0"),
  Axis1("motion.axis1"),
  Axis0MinPositionLimit("motion.axis0.minPositionLimit"),
  Axis0MaxPositionLimit("motion.axis0.maxPositionLimit"),
  Axis0Velocity("motion.axis0.velocity"),
  Spindle0("motion.spindle0"),
  Spindle1("motion.spindle1"),
  Spindle0Speed("motion.spindle0.speed"),
  Spindle0Scale("motion.spindle0.scale"),
  Spindle0CssMaximum("motion.spindle0.cssMaximum"),
  Spindle0CssFactor("motion.spindle0.cssFactor"),
  Spindle0State("motion.spindle0.state"),

  /** 0 stopped, 1 forward, -1 reverse */
  Spindle0Direction("motion.spindle0.direction"),

  /** 0 released, 1 engaged */
  Spindle0Brake("motion.spindle0.brake"),

  /** 1 increasing, -1 decreasing, 0 neither */
  Spindle0Increasing("motion.spindle0.increasing"),
  Spindle0Enabled("motion.spindle0.enabled"),
  Spindle0OrientState("motion.spindle0.orientState"),
  Spindle0OrientFault("motion.spindle0.orientFault"),
  Spindle0OverrideEnabled("motion.spindle0.overrideEnabled"),
  Spindle0Homed("motion.spindle0.homed"),
  Motion64DigitalInputsInt("motion.digitalInputsInt"),
  Motion64DigitalOutputsInt("motion.digitalOutputsInt"),
  Motion64AnalogInputsDouble("motion.analogInputsDouble"),
  Motion64AnalogOutputsDouble("motion.analogOutputsDouble"),
  MotionDebug("motion.debug"),
  MotionOnSoftLimit("motion.onSoftLimit"),
  ExternalOffsetsApplied("motion.externalOffsetsApplied"),
  ExternalOffsetsPositionXStart("motion.externalOffsetPosXStart"),
  NumExtraJoints("motion.numExtraJoints"),
  IoCycleTime("io.cycleTime"),
  IoDebug("io.debug"),
  IoReason("io.reason"),
  IoFaultDuringM6("io.faultDuringM6"),
  IoPocketPrepared("io.tool.pocketPrepared"),
  IoLoadedTool("io.tool.toolInSpindle"),
  IoCoolantMist("io.coolant.mist"),
  IoCoolantFlood("io.coolant.flood"),
  IoAuxEstop("io.aux.estop"),
  IoAuxLubeOn("io.aux.lubeOn"),
  IoAuxLubeLevelOk("io.aux.lubeLevelOk");

  companion object {
    private val map = values().associateBy(Key::textDescription)
    fun fromString(text: String) = map[text]
  }
}
