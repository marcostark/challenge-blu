package repository

import domain.Transaction

interface ITransactionRepository {
    fun findAll(): List<Transaction>
    fun save (transactions: List<List<String>>, append: Boolean = false)
}