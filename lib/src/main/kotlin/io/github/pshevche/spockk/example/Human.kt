package io.github.pshevche.spockk.example

data class Human(override val name: String) : Being {
    override fun greet(other: Being): String = "Hello, ${other.name}!"
}
