package io.github.pshevche.spockk.example

interface SubspaceRelay {
    fun transmit(channel: String, message: String)
    fun signalStrength(target: String): Int
}
