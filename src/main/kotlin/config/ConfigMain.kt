package me.vongshin.config

import config.Config
import me.vongshin.writeAnyToFile

const val JSON_FILE_NAME = "config.json"
fun configMain() {
    val config = Config()
    config.uploadUrl = "https://4ddc-2408-8956-c1-c1f-75cb-db77-2290-bebd.ngrok-free.app"
    writeAnyToFile(config, JSON_FILE_NAME)
}






