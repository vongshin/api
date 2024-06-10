package me.vongshin

import com.google.gson.GsonBuilder
import me.vongshin.config.configMain
import me.vongshin.ota.otaMain
import java.io.File
import java.io.FileWriter


fun main(){
    configMain()
    otaMain()
    println("finish")
}

fun writeAnyToFile(obj: Any, path: String){
    val file = File("${getRootPath()}/$path")
    val json = GsonBuilder().setPrettyPrinting().create().toJson(obj)
    if(!file.exists()) file.createNewFile()
    val fw = FileWriter(file, false)
    fw.write(json)
    fw.flush()
    fw.close()
}

fun getRootPath() = System.getProperty("user.dir")