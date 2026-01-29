package io.github.pshevche.spockk.example

data class Vulcan(override val name: String): Being {
    override fun greet(other: Being): String = "Live long and prosper, ${other.name}!"
}
