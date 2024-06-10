package ota

class OTAInfo {
    var name: String? = null
    var md5: String? = null
    var size: String? = null
    var url: String? = null
    var model: List<String> = listOf("A8", "A8S")
    var modules: List<Module>? = null
    var description: String? = null
}