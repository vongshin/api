package ota

import com.google.gson.annotations.SerializedName
import ota.Module

class OTAInfo {
    var name:String? = null
    var md5:String? = null
    var url:String? = null
    var modules: List<Module>? = null

}