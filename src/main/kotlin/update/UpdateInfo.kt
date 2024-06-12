package update

import me.vongshin.getRootPath

class UpdateInfo {
    var name: String? = null
    var label: String? = null
    var url: String? = null
        set(value) {
            field = value
            md5 = md5Hex("${getRootPath()}/$url")
            size = calSize("${getRootPath()}/$url")
        }
    var md5: String? = null
    var size: String? = null
    var model: List<String> = listOf("A8", "A8S")
    var modules: List<UpdateModule>? = null
    var description: String? = null
    var minAppVersion: String? = null
}