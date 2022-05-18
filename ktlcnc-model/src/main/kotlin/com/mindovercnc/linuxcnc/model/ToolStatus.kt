package com.mindovercnc.linuxcnc.model

data class ToolStatus(
    val pocketPrepared: Int,
    val currentLoadedTool: Int = 0
)
