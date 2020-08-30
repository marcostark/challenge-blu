package repository.impl

import domain.Account
import domain.Extract
import repository.IExtractRepository
import utils.Utils
import utils.Utils.Companion.extractDigit
import java.lang.Exception

class ExtractFileRepository(
    private val pathFile: String
): IExtractRepository {
    override fun findAll(): List<Extract> {
        val transactionList = mutableListOf<Extract>()

        try {
            val accounts = Utils.loadFile(pathFile)

            if(accounts.isNotEmpty()) {
                accounts.forEachIndexed { index, row ->
                    // Ignorando a primeira linha que possui o nomes das colunas
                    if(index != 0) {

                        val resul = Utils.extractContendFile(row)
                        val(number, digit) = resul[0].extractDigit()
                        val account = Account(number, digit, resul[1].toDouble(), resul[2].toDouble())
                        val transaction = Extract(account)
                        transactionList.add(transaction)
                    }
                }
            }
        } catch (ex: Exception) {
            println("Error: $ex")
        }
        return transactionList
    }
}