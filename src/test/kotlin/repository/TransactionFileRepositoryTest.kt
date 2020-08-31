package repository.impl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.Constants
import utils.Utils

internal class TransactionFileRepositoryTest {

    private val pathFile = Utils.loadFilesResource("transactions.csv")

    private val filePersistence = TransactionFileRepository(pathFile)

    @Test
    fun testFindAllTransaction() {
        val transactions = filePersistence.findAll()
        assertNotNull(transactions)
    }

    @Test
    fun testSaveAllTransaction() {
        val transactions = listOf(listOf("Conta", "Depósitos", "Total de Bônus"), listOf("1234-5","5","10.0"))
        filePersistence.save(transactions, "src/test/resources/${Constants.EXTRACT_FILENAME}")
        val extractFilePath = Utils.loadFilesResource("extract.csv")
        assertNotNull(extractFilePath)
    }
}