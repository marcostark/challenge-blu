package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UtilsTest {

    private val accountNumber = "1234-5"

    @Test
    fun testExtractDigit() {
        val (_, digit) = accountNumber.extractNumberAndDigit()
        assertEquals(5, digit)
    }

    @Test
    fun testExtractAccountNumber() {
        val (number, _) = accountNumber.extractNumberAndDigit()
        assertEquals("1234", number)
    }

    @Test
    fun testLoadFileNotEmpty() {
        val pathFile = Utils.loadResource("transactions.csv")
        println(pathFile)
        val fileLoaded = Utils.loadFile(pathFile)
        assertFalse(fileLoaded.isEmpty())
    }

    private fun String.extractNumberAndDigit(): Result {
        val accountNumber = split("-")
        val digit = accountNumber[1].toInt()
        val number = accountNumber[0]
        return Result(number, digit)
    }
}