package com.mindovercnc.linuxcnc.model

import java.util.*

data class MessageBundle(
    val emcMessages: List<SystemMessage>,
    val uiMessages: Map<UiMessage, Date>
)
