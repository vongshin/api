package config

import com.google.gson.annotations.SerializedName

class Config {
    @SerializedName("upload_url")
    var uploadUrl:String? = null
}