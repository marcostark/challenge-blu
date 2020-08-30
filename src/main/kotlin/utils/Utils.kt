package utils

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
import java.lang.Exception

class Utils {

    companion object {

        fun String.extractDigit(): Result {
            val accountNumber = split("-")
            val number = accountNumber[0]
            val digit = accountNumber[1].toInt()
            return Result(number, digit)
        }

        fun loadFile(path: String):List<List<String>> {
            var contend: List<List<String>> = mutableListOf()
            try {
                val file = File(path)
                contend = csvReader().readAll(file)
            } catch (ex: Exception) {
                println("Error $ex")
            }
            return contend
        }

        fun loadFilesResource(fileName: String): String {
            val resource = this::class.java.classLoader.getResource(fileName)
            return resource!!.file
        }

        fun extractContendFile(row: List<String>): List<String> {
            if (row.size == 1) {
                for(value in row) {
                    val properties = value.split(";")
                    return properties
                }
            }
            return row
        }
    }
}

data class Result(val number: String, val digit: Int)