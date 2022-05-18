package com.mindovercnc.linuxcnc.model

data class PositionState(
    val absPos: Position,
    val g5xPos: Position,
    val toolPos: Position,
    val g92Pos: Position
)