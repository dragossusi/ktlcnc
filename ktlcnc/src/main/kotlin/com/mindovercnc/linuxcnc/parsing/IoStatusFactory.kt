package com.mindovercnc.linuxcnc.parsing

import com.mindovercnc.linuxcnc.model.IoStatus
import com.mindovercnc.linuxcnc.model.ToolStatus
import com.mindovercnc.linuxcnc.nml.BuffDescriptor
import com.mindovercnc.linuxcnc.nml.Key
import java.nio.ByteBuffer

class IoStatusFactory(descriptor: BuffDescriptor) : ParsingFactory<IoStatus>(descriptor) {

    override fun parse(byteBuffer: ByteBuffer) = IoStatus(
        cycleTime = byteBuffer.getDoubleForKey(Key.IoCycleTime)!!,
        reason = byteBuffer.getIntForKey(Key.IoReason)!!,
        isM6Fault = byteBuffer.getBooleanForKey(Key.IoFaultDuringM6)!!,
        toolStatus = ToolStatus(
            pocketPrepared = byteBuffer.getIntForKey(Key.IoPocketPrepared)!!,
            currentLoadedTool = byteBuffer.getIntForKey(Key.IoLoadedTool)!!
        ),
        isMistOn = byteBuffer.getBooleanForKey(Key.IoCoolantMist)!!,
        isFloodOn = byteBuffer.getBooleanForKey(Key.IoCoolantFlood)!!,
        isEstopActive = byteBuffer.getBooleanForKey(Key.IoAuxEstop)!!,
        isLubePumpOn = byteBuffer.getBooleanForKey(Key.IoAuxLubeOn)!!,
        isLubeLevelOk = byteBuffer.getBooleanForKey(Key.IoAuxLubeLevelOk)!!
    )
}