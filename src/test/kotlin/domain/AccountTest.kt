package domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AccountTest {

    private val account = Account("1234",5)

    @Test
    fun testAccountNumberFormated() {
        assertEquals("1234-5", account.getNumberAndDigit())
    }
}