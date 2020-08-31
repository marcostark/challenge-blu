package service.impl

import domain.Account
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import repository.impl.TransactionFileRepository
import utils.Utils

internal class TransactionServiceTest {

    private val pathFile = Utils.loadFilesResource("transactions.csv")

    private val filePersistence = TransactionFileRepository(pathFile)

    private val accountService = AccountService()

    private var transactionService = TransactionService(filePersistence, accountService)

    @Test
    fun testCalculateBonusAccountPremium() {
        val bonus = transactionService.calculateBonus(Account("1234",3))
        assertEquals(10.0, bonus)
    }

    @Test
    fun testCalculateBonusAccountExecutive() {
        val bonus = transactionService.calculateBonus(Account("1234",5))
        assertEquals(5.0, bonus)
    }

    @Test
    fun testCalculateBonusAccountTraditional() {
        val bonus = transactionService.calculateBonus(Account("1234",0))
        assertEquals(1.0, bonus)
    }
}