package ota

data class Module(
    val name: String,
    val version: String,
    val path: String = "/EPT_System"
)

public infix fun String.module(that: String): Module = Module(this, that)