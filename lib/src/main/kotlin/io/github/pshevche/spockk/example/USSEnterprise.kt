package io.github.pshevche.spockk.example

class USSEnterprise {

    val checks = mutableListOf<String>()

    fun start() {
        println("Starting USS Enterprise...")
    }

    fun reset() {
        println("Resetting USS Enterprise...")
        checks.clear()
    }

    fun check(system: String) {
        println("Checking $system...")
        checks.add(system)
    }

    fun stop() {
        println("Stopping USS Enterprise...")
    }
}
