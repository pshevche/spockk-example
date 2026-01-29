package io.github.pshevche.spockk.example

import io.github.pshevche.spockk.lang.expect
import io.github.pshevche.spockk.lang.given
import io.github.pshevche.spockk.lang.then
import io.github.pshevche.spockk.lang.variables
import io.github.pshevche.spockk.lang.`when`
import io.github.pshevche.spockk.lang.where
import spock.lang.Specification
import spock.lang.Unroll
import kotlin.test.assertEquals

class DataDrivenSpec : Specification() {

    fun `spock can greet #species`(species: String, being: Being) {
        given
        val spock = Vulcan("Spock")

        expect
        assertEquals("Live long and prosper, ${being.name}!", spock.greet(being))

        where
        species  ; being
        "vulcan" ; Vulcan("Sarek")
        "human"  ; Human("Kirk")
    }

    @Unroll("kirk can greet #species")
    fun `kirk greetings`(species: String, being: Being) {
        given
        val kirk = Human("Kirk")

        `when`
        val greeting = kirk.greet(being)

        then
        assertEquals("Hello, ${being.name}!", greeting)

        where
        variables(species, being).from(listOf("vulcan", "human"), listOf(Vulcan("Spock"), Human("Scotty")))
    }
}