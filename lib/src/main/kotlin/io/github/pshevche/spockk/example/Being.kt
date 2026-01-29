package io.github.pshevche.spockk.example

interface Being {
    val name: String
    fun greet(other: Being): String
}