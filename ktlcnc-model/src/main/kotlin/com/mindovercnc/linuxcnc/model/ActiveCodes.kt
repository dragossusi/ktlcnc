package com.mindovercnc.linuxcnc.model

data class ActiveCodes(val gCodes: List<Float>, val mCodes: List<Float>) {
  private fun <T : ActiveCode> translateCode(values: Array<T>): T? {
    gCodes.forEach { code ->
      val found = values.find { it.value == code }
      if (found != null) return found
    }
    return null
  }

  val distanceMode: DistanceMode? = translateCode(DistanceMode.values())

  val feedMode: FeedMode? = translateCode(FeedMode.values())

  val spindleMode: SpindleMode? = translateCode(SpindleMode.values())
}

interface ActiveCode {
  val value: Float
}

enum class DistanceMode(override val value: Float) : ActiveCode {
  ABSOLUTE(90f),
  RELATIVE(91f)
}

enum class FeedMode(override val value: Float) : ActiveCode {
  UNITS_PER_MINUTE(94f),
  UNITS_PER_REVOLUTION(95f)
}

enum class SpindleMode(override val value: Float) : ActiveCode {
  CSS(96f),
  RPM(97f),
}
