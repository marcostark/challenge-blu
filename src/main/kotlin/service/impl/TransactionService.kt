package service.impl

import domain.Account
import domain.Extract
import domain.Transaction
import repository.ITransactionRepository
import service.IAccountService
import service.ITransactionService
import utils.Constants

class TransactionService(
    private val filePersitence: ITransactionRepository,
    private val accountService: IAccountService
): ITransactionService {

    override fun findAll(): List<Transaction> {
        return filePersitence.findAll()
    }

    override fun processTransaction(transactions: List<Transaction>): List<Extract> {
        val extract = mutableListOf<Extract>()
        val accountList = mutableListOf<Account>()

        transactions.forEach { transaction ->
            val digit = transaction.account.digit
            val account = transaction.account
            if (digit != null) {
                val bonus = calculateBonus(account)
                val acc = accountService.updateBalance(transaction, bonus)
                acc.bonus = bonus
                accountList.add(acc)
            }
        }

        val extractList = (accountList)
            .groupBy { it.number }
            .values
            .map {
                it.reduce {
                        previous, current -> Account(current.number, current.digit, previous.balance + current.balance, current.bonus)
                }
            }

        val headerExtract = listOf(listOf("Conta", "Depósitos", "Total de Bônus"))
        filePersitence.save(headerExtract, Constants.EXTRACT_FILENAME)

        extractList.forEach { acc ->
            val rows = listOf(listOf(acc.getNumberAndDigit(), acc.balance.toString(), acc.bonus.toString()))
            filePersitence.save(rows, Constants.EXTRACT_FILENAME, true)
        }
        return extract
    }

    fun calculateBonus(account: Account): Double {
        return when(account.digit) {
            0 -> Constants.TAX_TRADITIONAL_ACCOUNT * 100
            in 1..3 -> Constants.TAX_PREMIUM_ACCOUNT * 100
            in 4..8 -> Constants.TAX_EXECUTIVE_ACCOUNT * 100
            else -> 0.0
        }
    }
}