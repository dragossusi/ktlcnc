package com.mindovercnc.linuxcnc.model

data class Position(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0,
    val a: Double = 0.0,
    val b: Double = 0.0,
    val c: Double = 0.0,
    val u: Double = 0.0,
    val v: Double = 0.0,
    val w: Double = 0.0,
    val r: Double = 0.0,
) {
    class Builder {
        var x: Double = 0.0
        var y: Double = 0.0
        var z: Double = 0.0
        var a: Double = 0.0
        var b: Double = 0.0
        var c: Double = 0.0
        var u: Double = 0.0
        var v: Double = 0.0
        var w: Double = 0.0
        var r: Double = 0.0

        fun build() = Position(
            x = x,
            y = y,
            z = z,
            a = a,
            b = b,
            c = c,
            u = u,
            v = v,
            w = w,
            r = r,
        )
    }
}
