package service

import domain.Account
import domain.Transaction

interface IAccountService {
    fun deposit(transaction: Transaction, bonus: Double): Account
}
