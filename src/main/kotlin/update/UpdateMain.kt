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
            model = listOf("A8S", "APOS A8S")
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
            model = listOf("A8", "APOS A8")
            description =
                """
                    位置信息:
                    1、默认打开位置信息
                """.trimIndent()
            modules = listOf(
                "gps_on" module "1.0.0"
            )
        },
        UpdateInfo().apply {
            name = "支付模块更新"
            label = "EpayUpdate"
            url = "update/EpayUpdate/APOS-EpayUpdate-V245-5.0.173-20231225.uns"
            model = listOf("A8", "APOS A8")
            description =
                """
                    支付模块:
                    1、添加A8支持国密
                """.trimIndent()
            modules = listOf(
                "s-module" module "2..18.16",
                "libEMV" module "1.5.22",
                "masterControl" module "1.4.0",
                "gps_on" module "1.0.0",
                "pinpad" module "4.6.1",
                "EMVKernel" module "210318"
            )
        },
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