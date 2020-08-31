package utils

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
import java.lang.Exception

class Utils {

    companion object {

        /**
         * @description: Extrai o digito da conta
         * que vem acoplado ao número da conta         *
         * @param accountNumber Número da conta anexado ao digito
         */
        fun String.extractDigit(): Result {
            val accountNumber = split("-")
            val number = accountNumber[0]
            val digit = accountNumber[1].toInt()
            return Result(number, digit)
        }

        /**
         * @description Carrega e extratir conteudo de um
         * arquivo         *
         * @param Caminho do arquivo
         * @return Lista de string com o conteúdo do arquivo
         */
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

        /**
         * @description Carrega um arquivo a a partir
         * da pasta resources do projeto
         * @param Nome do arquivo a ser carregado
         * @return Caminho do arquivo no sistema
         */
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

/**
 * Classe utilitaria utilizada para
 * retornar uma tupla de valores
 */
data class Result(val number: String, val digit: Int)