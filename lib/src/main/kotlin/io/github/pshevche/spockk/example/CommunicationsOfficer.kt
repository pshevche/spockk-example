package io.github.pshevche.spockk.example

class CommunicationsOfficer(private val relay: SubspaceRelay) {

    fun hail(target: String, message: String) {
        relay.transmit("hailing", "$target: $message")
    }

    fun canReach(target: String): Boolean = relay.signalStrength(target) >= 50
}
