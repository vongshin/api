package me.vongshin.config

import com.google.gson.GsonBuilder
import config.Config
import me.vongshin.getRootPath
import me.vongshin.writeAnyToFile
import java.io.File
import java.io.FileWriter

const val JSON_FILE_NAME = "config.json"
fun configMain() {
    val config = Config()
    config.uploadUrl = "https://4ddc-2408-8956-c1-c1f-75cb-db77-2290-bebd.ngrok-free.app"
    writeAnyToFile(config, JSON_FILE_NAME)
}






