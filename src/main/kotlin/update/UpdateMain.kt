package update

import me.vongshin.getRootPath
import me.vongshin.writeAnyToFile
import org.apache.commons.codec.digest.DigestUtils
import update.UpdateModule
import update.UpdateInfo
import java.io.File
import java.io.FileInputStream
import java.math.BigDecimal
import java.math.RoundingMode

const val JSON_FILE_NAME = "update/update.json"
fun updateMain(){
    val updateInfos = listOf(
        UpdateInfo().apply {
            name = "工行客户定制资源包"
            label = "CustomRes"
            url = "update/CustomRes/CustomRes_ICBC_AND-S1-DELTA_1.5.0_20240529.uns"
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
        UpdateInfo().apply {
            name = "位置信息开关设置"
            label = "LocationInfo"
            url = "update/LocationInfo/APOS_GPS_on-NETWORKOnly.pkg"
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
    writeAnyToFile(updateInfos, JSON_FILE_NAME)

}
public infix fun String.module(that: String): UpdateModule = UpdateModule(this, that)
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