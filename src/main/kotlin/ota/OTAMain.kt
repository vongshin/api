package me.vongshin.ota

import me.vongshin.getRootPath
import me.vongshin.writeAnyToFile
import org.apache.commons.codec.digest.DigestUtils
import ota.OTAInfo
import ota.module
import java.io.File
import java.io.FileInputStream
import java.math.BigDecimal
import java.math.RoundingMode

const val JSON_FILE_NAME = "ota/ota.json"
fun otaMain(){
    val otaInfos = listOf(
        OTAInfo().apply {
            name = "CustomRes"
            url = "ota/CustomRes/CustomRes_ICBC_AND-S1-DELTA_1.5.0_20240529.uns"
            model = listOf("A8S")
            md5 = md5Hex("${getRootPath()}/$url")
            size = calSize("${getRootPath()}/$url")
            description =
                """
                    客户资源包:
                    1、支持中石油明文PIN
                """.trimIndent()
            modules = listOf(
                "CustomRes" module "1.5.0"
            )
        },
        OTAInfo().apply {
            name = "LocationInfo"
            url = "ota/LocationInfo/APOS_GPS_on-NETWORKOnly.pkg"
            model = listOf("A8")
            md5 = md5Hex("${getRootPath()}/$url")
            size = calSize("${getRootPath()}/$url")
            description =
                """
                    位置信息:
                    1、默认打开位置信息
                """.trimIndent()
            modules = listOf(
                "gps_on" module "1.0.0"
            )
        }
    )
    //
    writeAnyToFile(otaInfos, JSON_FILE_NAME)

}

fun md5Hex(name: String): String = DigestUtils.md5Hex(FileInputStream(name)).uppercase()

fun calSize(name: String): String{
    val file = File(name)
    var size = file.length() * 1.0
    if(size < 1024){
        return "$size Byte"
    }
    size /= 1024
    if(size < 1024){
        return "${BigDecimal.valueOf(size).setScale(2, RoundingMode.UP).stripTrailingZeros()} KB"
    }
    size /= 1024
    return "${BigDecimal.valueOf(size).setScale(2, RoundingMode.UP).stripTrailingZeros()} MB"
}