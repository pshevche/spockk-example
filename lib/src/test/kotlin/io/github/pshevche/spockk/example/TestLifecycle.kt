package io.github.pshevche.spockk.example

import io.github.pshevche.spockk.lang.cleanup
import io.github.pshevche.spockk.lang.then
import io.github.pshevche.spockk.lang.`when`
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class TestLifecycle : Specification() {

    @Shared
    @AutoCleanup("stop")
    val ussEnterprise = USSEnterprise()

    fun setupSpec() {
        ussEnterprise.start()
    }

    fun setup() {
        assert(ussEnterprise.checks.isEmpty())
    }

    fun `check systems 1`() {
        `when`
        ussEnterprise.check("bridge")
        ussEnterprise.check("engineering")

        then
        assert(ussEnterprise.checks.size == 2)

        cleanup
        ussEnterprise.reset()
    }

    fun `check systems 2`() {
        `when`
        ussEnterprise.check("medical")
        ussEnterprise.check("transport")
        ussEnterprise.check("security")

        then
        assert(ussEnterprise.checks.size == 3)

        cleanup
        ussEnterprise.reset()
    }
}
