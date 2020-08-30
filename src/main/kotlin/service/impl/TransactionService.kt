package service.impl

import domain.Extract
import domain.Transaction
import repository.ITransactionRepository
import service.ITransactionService

class TransactionService(
    private val filePersitence: ITransactionRepository
): ITransactionService {

    override fun findAll(): List<Transaction> {
        return filePersitence.findAll()
    }

    override fun processTransaction(transactions: List<Transaction>): List<Extract> {
        TODO("Not yet implemented")
    }
}