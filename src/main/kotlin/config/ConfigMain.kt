package me.vongshin.config

import com.google.gson.GsonBuilder
import config.Config
import java.io.File
import java.io.FileWriter

const val JSON_FILE_NAME = "config.json"
fun configMain() {
    val config = Config()
    config.uploadUrl = "https://4ddc-2408-8956-c1-c1f-75cb-db77-2290-bebd.ngrok-free.app"
    saveToFile(config)
}

private fun saveToFile(config: Config){
    val json = GsonBuilder().setPrettyPrinting().create().toJson(config)
    println(json)
    val file = File("${System.getProperty("user.dir")}/$JSON_FILE_NAME")
    writeJsonToFile(json, file)
}

private fun writeJsonToFile(json: String, file: File){
    if(!file.exists()) file.createNewFile()
    val fw = FileWriter(file, false)
    fw.write(json)
    fw.flush()
    fw.close()
}



