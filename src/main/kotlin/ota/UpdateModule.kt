package ota

data class UpdateModule(
    val name: String,
    val version: String,
    val path: String = "/EPT_System"
)

