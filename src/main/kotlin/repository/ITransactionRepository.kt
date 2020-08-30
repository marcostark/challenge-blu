package repository

import domain.Transaction

interface ITransactionRepository {
    fun findAll(): List<Transaction>
    fun save (rows: List<List<String>>, targetFileName: String, append: Boolean = false)
}