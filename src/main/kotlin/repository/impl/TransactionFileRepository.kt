package repository.impl

import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import domain.Account
import domain.Transaction
import repository.ITransactionRepository
import utils.Utils
import utils.Utils.Companion.extractDigit
import java.lang.Exception

class TransactionFileRepository(
    private val pathFile: String
): ITransactionRepository {
    override fun findAll(): List<Transaction> {
        val transactionList = mutableListOf<Transaction>()

        try {
            val accounts = Utils.loadFile(pathFile)

            if(accounts.isNotEmpty()) {
                accounts.forEach { row ->
                    for(value in row) {
                        val properties = value.split(";")
                        val(number, digit) = properties[0].extractDigit()
                        val account = Account(number, digit)

                        val transaction = Transaction(account, properties[1].toDouble())
                        transactionList.add(transaction)
                    }
                }
            }
        } catch (ex: Exception) {
            println("Error: $ex")
        }
        return transactionList
    }

    override fun save(rows: List<List<String>>, targetFileName:String, append: Boolean) {
        csvWriter().writeAll(rows, targetFileName, append = append)
    }
}