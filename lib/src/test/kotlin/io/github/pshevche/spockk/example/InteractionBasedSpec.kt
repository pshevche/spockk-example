package io.github.pshevche.spockk.example

import io.github.pshevche.spockk.lang.Mock
import io.github.pshevche.spockk.lang.Stub
import io.github.pshevche.spockk.lang.and
import io.github.pshevche.spockk.lang.any
import io.github.pshevche.spockk.lang.did
import io.github.pshevche.spockk.lang.expect
import io.github.pshevche.spockk.lang.given
import io.github.pshevche.spockk.lang.noMoreInteractions
import io.github.pshevche.spockk.lang.returns
import io.github.pshevche.spockk.lang.then
import io.github.pshevche.spockk.lang.times
import io.github.pshevche.spockk.lang.`when`
import spock.lang.Specification

class InteractionBasedSpec : Specification() {

    fun `hailing a target transmits exactly one message on the hailing channel`() {
        given("a relay we only care about the calls to")
        val relay = Mock(SubspaceRelay::class.java)

        and
        val uhura = CommunicationsOfficer(relay)

        `when`("Uhura hails Starfleet")
        uhura.hail("Starfleet", "Kirk here")

        then("the message went out once, and nothing else was asked of the relay")
        1 * relay.transmit("hailing", "Starfleet: Kirk here")
        noMoreInteractions(relay)
    }

    fun `a target is only reachable while the signal holds up`() {
        given("a relay stubbed to report a signal strength per target")
        val relay = Stub(SubspaceRelay::class.java) {
            signalStrength("Vulcan") returns 80
            signalStrength("Romulus") returns 20
        }

        and
        val uhura = CommunicationsOfficer(relay)

        expect
        uhura.canReach("Vulcan")

        and
        !uhura.canReach("Romulus")
    }

    fun `every hail carries the message it was given`() {
        given
        val relay = Mock(SubspaceRelay::class.java)
        val uhura = CommunicationsOfficer(relay)
        val transmitted = mutableListOf<String>()

        `when`("two hails go out")
        uhura.hail("Starfleet", "Kirk here")
        uhura.hail("Vulcan", "Spock here")

        then("both were transmitted, and we can inspect what they carried")
        2 * relay.transmit("hailing", any()) did { args -> transmitted += args[1] as String }
        transmitted == listOf("Starfleet: Kirk here", "Vulcan: Spock here")
    }
}
