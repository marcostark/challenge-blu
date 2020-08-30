package service.impl

import domain.Transaction
import repository.ITransactionRepository
import service.ITransactionService

class TransactionService(
    private val filePersitence: ITransactionRepository
): ITransactionService {

    override fun findAll(): List<Transaction> {
        return filePersitence.findAll()
    }
}