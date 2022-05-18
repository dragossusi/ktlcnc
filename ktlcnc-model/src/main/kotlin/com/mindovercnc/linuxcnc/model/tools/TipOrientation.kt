package com.mindovercnc.linuxcnc.model.tools

enum class TipOrientation(val orient: Int, val angle: Int) {
    Position1(1, 135),
    Position2(2, 45),
    Position3(3, 315),
    Position4(4, 225),
    Position5(5, 180),
    Position6(6, 90),
    Position7(7, 0),
    Position8(8, 270),
    Position9(9, 0);

    companion object {
        fun getOrientation(orient: Int): TipOrientation {
            return values().find { it.orient == orient } ?: Position9
        }
    }
}