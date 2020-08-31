package repository.impl

import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import domain.Account
import domain.Extract
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
                accounts.forEachIndexed { index, row ->
                    // Ignorando a primeira linha que possui o nomes das colunas
                    if(index != 0) {

                        val resul = Utils.extractContendFile(row)
                        val(number, digit) = resul[0].extractDigit()
                        val account = Account(number, digit)
                        val transaction = Transaction(account, resul[1].toDouble())
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

    override fun extract(): List<Extract> {
        TODO("Not yet implemented")
    }
}