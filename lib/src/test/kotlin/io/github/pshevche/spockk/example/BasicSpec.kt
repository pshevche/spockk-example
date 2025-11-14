package io.github.pshevche.spockk.example

import io.github.pshevche.spockk.lang.and
import io.github.pshevche.spockk.lang.expect
import io.github.pshevche.spockk.lang.given

class BasicSpec {

    fun `length of Spock's and his friends' names`() {
        given
        val spock = "Spock"
        val kirk = "Kirk"

        and
        val scotty = "Scotty"

        expect
        assert(spock.length == 5)
        assert(kirk.length == 4)

        and
        assert(scotty.length == 6)
    }
}