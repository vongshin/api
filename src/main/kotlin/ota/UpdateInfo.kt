package ota

class UpdateInfo {
    var name: String? = null
    var label: String? = null
    var md5: String? = null
    var size: String? = null
    var url: String? = null
    var model: List<String> = listOf("A8", "A8S")
    var modules: List<UpdateModule>? = null
    var description: String? = null
}