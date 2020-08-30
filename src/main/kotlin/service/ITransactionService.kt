package service

import domain.Transaction

interface ITransactionService {

    fun findAll(): List<Transaction>
}