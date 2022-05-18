package com.mindovercnc.linuxcnc.model

private const val SETTING_FEED_RATE_INDEX = 1
private const val SETTING_SPINDLE_SPEED_INDEX = 2

data class TaskStatus(
    val taskMode: TaskMode,
    val taskState: TaskState,
    val execState: TaskExecState,
    val interpreterState: InterpreterState,
    /**
     * Current subroutine level
     * 0 - if not in a subroutine, > 0 otherwise
     */
    val subroutineCallLevel: Int,
    /**
     * The line motion is executing (may lag)
     */
    val motionLine: Int,
    /**
     * The line interpreter has read to
     */
    val readLine: Int,
    /**
     * If true, it means stop on M1
     */
    val isOptionalStopEnabled: Boolean,
    /**
     * If true, it means ignore lines starting with '/'
     */
    val isBlockDeleteEnabled: Boolean,
    /**
     * Timeout happened on digital input
     */
    val isDigitalInputTimeout: Boolean,
    val loadedFile: String? = null,
    val command: String? = null,
    /**
     * In user units, currently active
     */
    val g5xOffset: Position,
    val g5xIndex: Int,
    val g92Offset: Position,
    val rotationXY: Double,
    val toolOffset: Position,
    val activeCodes: ActiveCodes,
    /**
     * Not sure how to interpret this double
     */
    val activeSettings: List<Double?>,

    val programUnits: LengthUnit,

    /**
     * The return value from rs274ngc function, only useful for new interpreter
     */
    val intepreterErrorCode: Int,
    val isTaskPaused: Boolean,
    /**
     * Delay time left for G4 or M66 and others that I don't know if they exist.
     */
    val delayLeft: Double,
    /**
     * Current length of the MDI input queue.
     */
    val mdiInputQueue: Int,
) {
    /**
     * The set feed rate, obtained from active settings
     */
    val setFeedRate: Double? = activeSettings[SETTING_FEED_RATE_INDEX]

    /**
     * The set spindle speed, obtained from active settings
     */
    val setSpindleSpeed: Double? = activeSettings[SETTING_SPINDLE_SPEED_INDEX]
}