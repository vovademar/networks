package medvedev.v

import java.io.File

class PrintFile {
    fun printFile(dir: String, fileName : String): String{
        val res: StringBuilder = java.lang.StringBuilder()
        val file = "./$dir/$fileName"
        if (!File(file).exists()){
            res.append("No such file or directory")
            return res.toString()
        }
        File(file).forEachLine {
            res.append(it)
            res.append("\n")
        }
        return res.toString()
    }
}