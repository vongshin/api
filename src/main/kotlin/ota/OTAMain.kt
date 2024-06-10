package me.vongshin.ota

import me.vongshin.getRootPath
import me.vongshin.writeAnyToFile
import org.apache.commons.codec.digest.DigestUtils
import ota.OTAInfo
import ota.module
import java.io.FileInputStream

const val JSON_FILE_NAME = "ota/ota.json"
fun otaMain(){
    val otaInfos = listOf(
        OTAInfo().apply {
            name = "CustomRes"
            url = "ota/CustomRes/CustomRes_ICBC_AND-S1-DELTA_1.5.0_20240529.uns"
            md5 = md5Hex("${getRootPath()}/$url")
            modules = listOf(
                "CustomRes" module "1.5.0"
            )
        }
    )
    writeAnyToFile(otaInfos, JSON_FILE_NAME)

}

fun md5Hex(name: String): String = DigestUtils.md5Hex(FileInputStream(name))