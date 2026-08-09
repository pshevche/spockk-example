package io.github.pshevche.spockk.example

import io.github.pshevche.spockk.lang.and
import io.github.pshevche.spockk.lang.expect
import io.github.pshevche.spockk.lang.given
import io.github.pshevche.spockk.lang.then
import io.github.pshevche.spockk.lang.`when`
import spock.lang.Specification
import kotlin.test.assertEquals

class BasicUsage : Specification() {

    fun `all beings have names`() {
        expect
        assertEquals("Spock", Vulcan("Spock").name)

        and
        Human("Kirk").name == "Kirk"
    }

    fun `spock greets kirk properly`() {
        given("Spock")
        val spock = Vulcan("Spock")

        and("Kirk")
        val kirk = Human("Kirk")

        `when`("Spock greets Kirk")
        val greeting = spock.greet(kirk)

        then("greeting is legendary")
        greeting == "Live long and prosper, Kirk!"
    }
}