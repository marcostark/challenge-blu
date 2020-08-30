package service

import domain.Extract
import domain.Transaction

interface ITransactionService {

    fun findAll(): List<Transaction>

    fun processTransaction(transactions: List<Transaction>): List<Extract>

}